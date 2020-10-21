import {BehaviorSubject, Observable, of} from 'rxjs';
import {CollectionViewer, DataSource} from '@angular/cdk/collections';
import {catchError, finalize} from 'rxjs/operators';
import {PaginatedResponse} from './paginated.response.model';

export class PaginatedDatasource<Model> implements DataSource<Model> {
  private subject = new BehaviorSubject<Model[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);
  private countSubject = new BehaviorSubject<number>(0);
  public counter$ = this.countSubject.asObservable();

  connect(collectionViewer: CollectionViewer): Observable<Model[]> {
    return this.subject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.subject.complete();
    this.loadingSubject.complete();
    this.countSubject.complete();
  }

  loadData(loadFunction: Observable<object>): void {
    this.loadingSubject.next(true);
    loadFunction.pipe(
      catchError(() => of([])),
      finalize(() => this.loadingSubject.next(false)))
      .subscribe((result: PaginatedResponse<Model>) => {
        this.subject.next(result.content);
        this.countSubject.next(result.totalElements);
      });
  }
}
