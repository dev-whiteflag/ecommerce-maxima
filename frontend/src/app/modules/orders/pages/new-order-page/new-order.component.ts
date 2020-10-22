import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatIconRegistry} from '@angular/material/icon';
import {DomSanitizer} from '@angular/platform-browser';
import {map, startWith} from 'rxjs/operators';
import {MatSnackBar} from '@angular/material/snack-bar';
import {OrdersService} from '../../services/orders.service';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {ClientService} from '../../../register/services/client.service';

export interface Tax {
  quantity: number;
}

@Component({
  selector: 'app-new-order',
  templateUrl: './new-order.component.html',
  styleUrls: ['./new-order.component.sass']
})
export class NewOrderComponent implements AfterViewInit, OnInit {
  autoComplete = new FormControl();
  options: string[] = ['One', 'Two', 'Three'];
  filteredOptions: Observable<string[]>;

  constructor(public service: OrdersService, public clients: ClientService, iconRegistry: MatIconRegistry,
              sanitizer: DomSanitizer, public snackBar: MatSnackBar) {
    iconRegistry.addSvgIcon('product-maxima',
      sanitizer.bypassSecurityTrustResourceUrl('assets/icons/icone-produtos.svg')
    );
    iconRegistry.addSvgIcon('client-maxima',
      sanitizer.bypassSecurityTrustResourceUrl('assets/icons/icone-cliente.svg')
    );
  }

  ngOnInit(): void {
    this.filteredOptions = this.autoComplete.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  ngAfterViewInit(): void {
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }
}
