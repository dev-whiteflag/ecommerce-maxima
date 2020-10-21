import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {
  private isAuth: boolean;

  constructor(public auth: AuthService, public router: Router) {}

  async canActivate(): Promise<boolean> {
    await this.auth.checkAuthenticated().subscribe(next => {
      this.isAuth = next;
    });
    if (this.isAuth) {
      return true;
    } else {
      await this.router.navigate(['login']);
    }
  }
}
