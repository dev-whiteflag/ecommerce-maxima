import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';

@Injectable()
export class ClientService {
  private readonly service = 'api';
  private readonly version = 'v1';
  private readonly endpoints = 'clients';
  private readonly URI = environment.uri + '/' + this.service + '/' + this.version + '/' + this.endpoints;
}
