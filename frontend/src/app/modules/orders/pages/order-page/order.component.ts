import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatIconRegistry} from '@angular/material/icon';
import {DomSanitizer} from '@angular/platform-browser';
import {MatPaginator} from '@angular/material/paginator';
import {MatDialog} from '@angular/material/dialog';
import {PaginatedDatasource} from '../../../../shared/models/paginated.datasource.model';
import {tap} from 'rxjs/operators';
import {ConfirmDialogComponent} from '../../../../shared/components/confirmation-dialog/confirm.dialog.component';
import {MatSnackBar} from '@angular/material/snack-bar';
import {OrdersService} from '../../services/orders.service';

export interface Order {
  uuid: string;
  code: string;
  totalValue: number;
  productQuantity: number;
  taxValue: number;
}

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.sass']
})
export class OrderComponent implements AfterViewInit {
  displayedColumns: string[] = ['uuid', 'code', 'totalValue', 'productQuantity', 'taxValue', 'actions'];
  dataSource = new PaginatedDatasource<Order>();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public service: OrdersService, iconRegistry: MatIconRegistry,
              sanitizer: DomSanitizer, public dialog: MatDialog, public snackBar: MatSnackBar) {
    iconRegistry.addSvgIcon('product-maxima',
      sanitizer.bypassSecurityTrustResourceUrl('assets/icons/icone-produtos.svg')
    );
  }

  ngAfterViewInit(): void {
    this.dataSource.loadData(
      this.service.getAllOrdersPaginated()
    );

    this.dataSource.counter$.pipe(
      tap((count) => {
          this.paginator.length = count;
        })).subscribe();

    this.paginator.page.pipe(
      tap(() => this.refreshData())).subscribe();
  }

  refreshData(): void {
    this.dataSource.loadData(
      this.service.getAllOrdersPaginated(this.paginator.pageIndex, this.paginator.pageSize),
    );
  }

  deleteOrder(uuid): void {
    this.dialog.open(ConfirmDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(next => {
      if (next === true){
        this.service.deleteOrder(uuid).subscribe(() => {
          this.openSnackBar('Pedido deletado com sucesso!', 'Fechar');
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
