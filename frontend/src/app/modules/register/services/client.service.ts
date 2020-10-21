import {HttpClient} from '@angular/common/http';
import {Observable, Subscription} from 'rxjs';
import {Injectable} from '@angular/core';
import {ApiService} from '../../../core/services/api.service';
import {Client} from '../pages/client.component';

@Injectable()
export class ClientService extends ApiService{
  constructor(private http: HttpClient) {
    super();
  }

  public sync(): void {
    this.http.get(this.URI + '/sync', this.headers)
      .subscribe(next => console.log('clients synced' + next), err => console.log(err));
  }

  public getAllClientsPaginated(page, size): Observable<object> {
    return this.http.post(this.URI + '/', {
      pageNumber: page,
      pageSize: size
    } , this.headers);
  }

}
