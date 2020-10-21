import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {ApiService} from '../../../shared/services/api.service';

@Injectable()
export class ClientService extends ApiService{
  constructor(private http: HttpClient) {
    super();
  }

  public sync(): void {
    this.http.get(this.URI + '/sync', this.headers)
      .subscribe(next => console.log('clients synced' + next), err => console.log(err));
  }

  public getAllClientsPaginated(page = 0, size = 5): Observable<object> {
    return this.http.post(this.URI + '/', {
      pageNumber: page,
      pageSize: size
    }, this.headers);
  }

  public createNewClient(nameInput, codeInput): Observable<object> {
    return this.http.post(this.URI + '/new', {
      name: nameInput,
      code: codeInput
    }, this.headers);
  }

}
