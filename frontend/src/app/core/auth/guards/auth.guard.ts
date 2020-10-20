import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(public auth: AuthService, public router: Router) {}

  canActivate(): boolean {
    this.auth.isAuthenticated().subscribe(state => {
      console.log('is-user-authenticated: ' + state);
      if (!state){
        console.log('auth: going to auth0 for login');
        this.auth.login();
      }
    });
    return true;
  }
}
