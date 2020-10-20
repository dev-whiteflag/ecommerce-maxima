import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable()
export class AuthService {
  constructor() {}

  public isAuthenticated = new BehaviorSubject<boolean>(false);

  async checkAuthenticated(): Promise<boolean> {
    const authenticated = Boolean(await localStorage.getItem('isAuthenticated'));
    return authenticated === true;
  }

  login(username: string, password: string): void {
    // Mockup of a Authentication Service Request
    const validation = !(username !== 'user' || password !== 'user');
    if (validation !== true) {
      throw Error('Invalid Credentials');
    }
    this.isAuthenticated.next(true);
    localStorage.setItem('isAuthenticated', 'true');
  }
}
