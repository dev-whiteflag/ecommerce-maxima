import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ClientModule} from './pages/client.module';
import {ClientService} from './services/client.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ClientModule
  ],
  providers: [ClientService],
  bootstrap: []
})
export class RegisterModule {
}
