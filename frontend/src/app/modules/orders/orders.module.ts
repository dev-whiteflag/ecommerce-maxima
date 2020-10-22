import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {OrdersService} from './services/orders.service';
import {TaxService} from './services/tax.service';
import {OrderModule} from './pages/order-page/order.module';
import {NewOrderModule} from './pages/new-order-page/new-order.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    OrderModule,
    NewOrderModule
  ],
  providers: [OrdersService, TaxService],
  bootstrap: []
})
export class OrdersModule {
}
