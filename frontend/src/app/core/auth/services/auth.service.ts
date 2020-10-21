import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {Router} from '@angular/router';

@Injectable()
export class AuthService {
  constructor(private router: Router) {}

  public isAuthenticated = new BehaviorSubject<boolean>(false);

  checkAuthenticated(): Observable<boolean> {
    const authenticated = Boolean(localStorage.getItem('isAuthenticated'));
    this.isAuthenticated.next(authenticated);
    return this.isAuthenticated.asObservable();
  }

  login(username: string, password: string): void {
    // Mockup of a Authentication Service Request
    const validation = !(username !== 'user' || password !== 'user');
    if (validation !== true) {
      throw Error('Invalid Credentials');
    }
    this.isAuthenticated.next(true);
    localStorage.setItem('isAuthenticated', 'true');
    this.router.navigate(['']);
  }
}
