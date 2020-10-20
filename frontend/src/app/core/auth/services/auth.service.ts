import { Injectable } from '@angular/core';

import { AuthService as Auth0Service } from '@auth0/auth0-angular';
import {Observable} from 'rxjs';

@Injectable()
export class AuthService {
  constructor(public auth: Auth0Service) {}

  public login(): void {
    this.auth.loginWithRedirect();
  }

  public isAuthenticated(): Observable<boolean> {
    return this.auth.isAuthenticated$;
  }

  public returnUserData(): Observable<any> {
    return this.auth.user$;
  }
}
