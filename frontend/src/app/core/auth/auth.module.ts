import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthGuard} from './guards/auth.guard';
import {AuthService} from './services/auth.service';
import {LoginModule} from './pages/login/login.module';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    LoginModule
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: []
})
export class AuthModule {
}
