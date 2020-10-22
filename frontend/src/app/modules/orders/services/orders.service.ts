import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {ApiService} from '../../../shared/services/api.service';
import {environment} from '../../../../environments/environment';

@Injectable()
export class OrdersService extends ApiService{
  public endpoints = 'orders';
  public readonly URI = environment.uri + '/' + this.service + '/' + this.version + '/' + this.endpoints;
  constructor(private http: HttpClient) {
    super();
  }

  public getAllOrdersPaginated(page = 0, size = 5): Observable<object> {
    return this.http.post(this.URI + '/', {
      pageNumber: page,
      pageSize: size
    }, this.headers);
  }

  public createNewOrder(nameInput, codeInput): Observable<object> {
    return this.http.post(this.URI + '/new', {
      name: nameInput,
      code: codeInput
    }, this.headers);
  }

  public deleteOrder(uuid): Observable<object> {
    return this.http.get(this.URI + '/delete/' + uuid, this.headers);
  }

}
