import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {ApiService} from '../../../shared/services/api.service';
import {environment} from '../../../../environments/environment';
import {Tax} from '../pages/new-order-page/new-order.component';

@Injectable()
export class TaxService extends ApiService {
  public service = 'tax';
  public endpoints = 'tax';
  public readonly URI = environment.uri + '/' + this.service + '/' + this.version + '/' + this.endpoints;
  constructor(private http: HttpClient) {
    super();
  }

  public calculateTax(productList: Tax[]): Observable<object> {
    return this.http.post(this.URI + '/', productList, this.headers);
  }

}
