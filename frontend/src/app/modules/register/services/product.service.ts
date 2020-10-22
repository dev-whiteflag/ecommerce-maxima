import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {ApiService} from '../../../shared/services/api.service';
import {environment} from '../../../../environments/environment';

@Injectable()
export class ProductService extends ApiService {
  public endpoints = 'products';
  public readonly URI = environment.uri + '/' + this.service + '/' + this.version + '/' + this.endpoints;
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

  public createNewProduct(nameInput, codeInput, priceInput): Observable<object> {
    return this.http.post(this.URI + '/new', {
      name: nameInput,
      code: codeInput,
      unitPrice: priceInput
    }, this.headers);
  }

  public deleteProduct(uuid): Observable<object> {
    return this.http.get(this.URI + '/delete/' + uuid, this.headers);
  }

}
