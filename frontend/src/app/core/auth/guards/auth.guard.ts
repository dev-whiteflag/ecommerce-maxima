import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(public auth: AuthService, public router: Router) {}

  async canActivate(): Promise<boolean> {
    if (await this.auth.checkAuthenticated() === true) {
      return true;
    } else {
      await this.router.navigate(['login']);
    }
  }
}
