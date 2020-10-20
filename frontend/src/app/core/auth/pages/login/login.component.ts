import {Component} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-dashboard',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent {
  constructor(public auth: AuthService, private snackBar: MatSnackBar) {
  }

  username = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required]);

  login(): void {
    if (this.username.invalid === false && this.password.invalid === false){
      try {
        this.auth.login(this.username.value, this.password.value);
      } catch (e) {
        this.openSnackBar(e, 'Fechar');
      }
    } else {
      this.openSnackBar('Verifique se suas credenciais estão corretas.', 'Fechar');
    }
  }

  getErrorMessage(type): string {
    if (type === 'username') {
      return 'Usuário não pode ser vazio!';
    } else if (type === 'password') {
      return 'Senha não pode ser vazio!';
    }
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }
}
