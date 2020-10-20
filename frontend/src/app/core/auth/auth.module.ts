import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthGuard} from './guards/auth.guard';
import {AuthService} from './services/auth.service';
import {LoginComponent} from './pages/login/login.component';

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: []
})
export class AuthModule {
}
