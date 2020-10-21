import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ClientModule} from './pages/client-page/client.module';
import {ClientService} from './services/client.service';
import {ProductModule} from './pages/product-page/product.module';
import {ProductService} from './services/product.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ClientModule,
    ProductModule
  ],
  providers: [ClientService, ProductService],
  bootstrap: []
})
export class RegisterModule {
}
