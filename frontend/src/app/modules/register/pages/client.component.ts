import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatIconRegistry} from '@angular/material/icon';
import {DomSanitizer} from '@angular/platform-browser';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {ClientService} from '../services/client.service';

export interface Client {
  uuid: string;
  name: string;
  code: string;
}

const ELEMENT_DATA: Client[] = [
  {uuid: '4f8e6b89-7b3f-450d-9f9d-03dba15d6e3a', name: 'Kegyu Guida', code: '146bbaf1-f5c3-440b-b60e-52d0a29bc837'},
  {uuid: '4f8e6b89-7b3f-450d-9f9d-03dba15d6e3a', name: 'Miohu Daein', code: '146bbaf1-f5c3-440b-b60e-52d0a29bc837'},
  {uuid: '4f8e6b89-7b3f-450d-9f9d-03dba15d6e3a', name: 'Kauvi Hifio', code: '146bbaf1-f5c3-440b-b60e-52d0a29bc837'},
];

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.sass']
})
export class ClientComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = ['name', 'code'];
  dataSource = new MatTableDataSource<Client>();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public service: ClientService, iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon('client-maxima',
      sanitizer.bypassSecurityTrustResourceUrl('assets/icons/icone-cliente.svg')
    );
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.service.sync();
    this.service.getAllClientsPaginated(this.paginator.pageIndex, this.paginator.pageSize)
      .subscribe(next => {
        this.dataSource.data = Object.values(next);
      }, err => console.log(err));
  }

  ngOnInit(): void {
    if (this.dataSource.data == null){
      this.service.getAllClientsPaginated(this.paginator.pageIndex, this.paginator.pageSize)
        .subscribe(next => {
          this.dataSource.data = Object.values(next);
        }, err => console.log(err));
    }
  }
}
