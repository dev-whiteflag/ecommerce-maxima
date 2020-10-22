import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatIconRegistry} from '@angular/material/icon';
import {DomSanitizer} from '@angular/platform-browser';
import {MatPaginator} from '@angular/material/paginator';
import {ClientService} from '../../services/client.service';
import {MatDialog} from '@angular/material/dialog';
import {ProductDialogComponent} from './product.dialog.component';
import {PaginatedDatasource} from '../../../../shared/models/paginated.datasource.model';
import {tap} from 'rxjs/operators';
import {ProductService} from '../../services/product.service';
import {ConfirmDialogComponent} from '../../../../shared/components/confirmation-dialog/confirm.dialog.component';
import {MatSnackBar} from '@angular/material/snack-bar';

export interface Product {
  uuid: string;
  name: string;
  code: string;
  unitPrice: number;
  imageUrl: string;
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.sass']
})
export class ProductComponent implements AfterViewInit {
  displayedColumns: string[] = ['name', 'code', 'unitPrice', 'actions'];
  dataSource = new PaginatedDatasource<Product>();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public service: ProductService, iconRegistry: MatIconRegistry,
              sanitizer: DomSanitizer, public dialog: MatDialog, public snackBar: MatSnackBar) {
    iconRegistry.addSvgIcon('product-maxima',
      sanitizer.bypassSecurityTrustResourceUrl('assets/icons/icone-produtos.svg')
    );
  }

  ngAfterViewInit(): void {
    this.service.sync();
    this.dataSource.loadData(
      this.service.getAllProductsPaginated()
    );

    this.dataSource.counter$.pipe(
      tap((count) => {
          this.paginator.length = count;
        })).subscribe();

    this.paginator.page.pipe(
      tap(() => this.refreshData())).subscribe();
  }

  newClient(): void {
    this.dialog.open(ProductDialogComponent, {
      width: '50%'
    });
    this.dialog.afterAllClosed.subscribe(() => {
      this.refreshData();
    });
  }

  refreshData(): void {
    this.dataSource.loadData(
      this.service.getAllProductsPaginated(this.paginator.pageIndex, this.paginator.pageSize),
    );
  }

  deleteClient(uuid): void {
    this.dialog.open(ConfirmDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(next => {
      if (next === true){
        this.service.deleteProduct(uuid).subscribe(() => {
          this.openSnackBar('Usuário deletado com sucesso!', 'Fechar');
          this.refreshData();
        });
      }
    }, err => this.openSnackBar(err, 'Fechar'));
    console.log(uuid);
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }
}
