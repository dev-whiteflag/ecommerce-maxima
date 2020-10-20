import {Component} from '@angular/core';
import {AuthService} from '../../auth/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.sass']
})
export class NavbarComponent {
  isAuthenticated: boolean;
  constructor(private auth: AuthService) {
    this.auth.checkAuthenticated().then(value => {
      this.isAuthenticated = value;
    });
  }
}
