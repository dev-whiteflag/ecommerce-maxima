import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthModule} from './auth/auth.module';
import {DashboardModule} from './dashboard/dashboard.module';
import {SkeletonModule} from './skeleton/skeleton.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AuthModule,
    SkeletonModule,
    DashboardModule,
  ],
  providers: [],
  bootstrap: []
})
export class CoreModule {
}
