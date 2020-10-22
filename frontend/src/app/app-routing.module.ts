import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DashboardComponent} from './core/dashboard/dashboard.component';
import {LoginComponent} from './core/auth/pages/login/login.component';
import {AuthGuard} from './core/auth/guards/auth.guard';
import {ClientComponent} from './modules/register/pages/client-page/client.component';
import {ProductComponent} from './modules/register/pages/product-page/product.component';
import {OrderComponent} from './modules/orders/pages/order-page/order.component';

const routes: Routes = [
  { path: '', component: DashboardComponent, canActivate: [AuthGuard]},
  { path: 'clientes', component: ClientComponent, canActivate: [AuthGuard]},
  { path: 'produtos', component: ProductComponent, canActivate: [AuthGuard]},
  { path: 'pedidos', component: OrderComponent, canActivate: [AuthGuard]},
  { path: 'pedidos/novo', component: OrderComponent, canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
