import {Component} from '@angular/core';
import {AuthService} from '../auth/services/auth.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.sass']
})
export class DashboardComponent {
  profile: any;

  constructor(public auth: AuthService) {
    auth.returnUserData().subscribe(res => {
      this.profile = res;
    });
  }

}
