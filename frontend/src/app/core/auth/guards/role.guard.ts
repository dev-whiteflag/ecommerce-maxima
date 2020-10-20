import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import {Injectable} from '@angular/core';
import {AuthService} from '../services/auth.service';

@Injectable()
export class RoleGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const routeId = route.data.id;
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
