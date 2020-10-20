import {Injectable} from '@angular/core';
import {AuthService} from './auth.service';
import {ProfileModel} from '../models/profile.model';

@Injectable()
export class ProfileService {
    token: string;
    profile: ProfileModel;

    constructor(public auth: AuthService) {
      this.token = auth.getAccessToken();
    }
}
