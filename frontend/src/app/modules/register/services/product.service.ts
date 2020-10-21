import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {ApiService} from '../../../shared/services/api.service';

@Injectable()
export class ProductService extends ApiService {
  public endpoints = 'products';
  constructor(private http: HttpClient) {
    super();
  }

  public sync(): void {
    this.http.get(this.URI + '/sync', this.headers)
      .subscribe(() => console.log('products synced'), err => console.log(err));
  }

  public getAllProductsPaginated(page = 0, size = 5): Observable<object> {
    return this.http.post(this.URI + '/', {
      pageNumber: page,
      pageSize: size
    }, this.headers);
  }

  public createNewProduct(nameInput, codeInput): Observable<object> {
    return this.http.post(this.URI + '/new', {
      name: nameInput,
      code: codeInput
    }, this.headers);
  }

}
