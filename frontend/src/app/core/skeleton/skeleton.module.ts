import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from './navbar/navbar.component';
import {SkeletonComponent} from './skeleton.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatBadgeModule} from '@angular/material/badge';
import {MatMenuModule} from '@angular/material/menu';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    SkeletonComponent,
    NavbarComponent
  ],
    imports: [
        CommonModule,
        FlexLayoutModule,
        MatToolbarModule,
        MatIconModule,
        MatButtonModule,
        MatBadgeModule,
        MatMenuModule,
        RouterModule
    ],
  providers: [],
  exports: [
    SkeletonComponent
  ],
  bootstrap: [SkeletonComponent]
})
export class SkeletonModule {
}
