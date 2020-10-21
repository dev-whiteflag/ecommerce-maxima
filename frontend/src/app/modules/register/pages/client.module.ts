import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ClientComponent} from './client.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';

@NgModule({
  declarations: [
    ClientComponent
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,
    MatCardModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [ClientComponent]
})
export class ClientModule {
}
