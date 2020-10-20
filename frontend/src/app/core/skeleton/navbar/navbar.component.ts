import {Component} from '@angular/core';
import {MatIconRegistry} from '@angular/material/icon';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.sass']
})
export class NavbarComponent {
  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {

    // Adds Vision Branding as a Icon.
    iconRegistry.addSvgIcon(
      'vision',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/branding/vision-logo.svg')
    );

  }
}
