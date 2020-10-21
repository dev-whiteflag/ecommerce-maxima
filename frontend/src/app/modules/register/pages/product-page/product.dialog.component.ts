import {Component} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {FormControl, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ClientService} from '../../services/client.service';

@Component({
  selector: 'app-client-dialog',
  templateUrl: 'product.dialog.component.html',
})
export class ProductDialogComponent {
  constructor(public dialogRef: MatDialogRef<ProductDialogComponent>,
              public snackBar: MatSnackBar, public service: ClientService) {}

  name = new FormControl('', [Validators.required]);
  code = new FormControl('');

  createNewUser(): void {
    if (this.name.value !== undefined && this.code.value !== undefined){
      this.service.createNewClient(this.name.value, this.code.value).subscribe((next) => {
        this.openSnackBar('Cliente criado com sucesso!', 'Fechar');
        this.closeDialog();
      }, err => {
        this.openSnackBar(err, 'Fechar');
      });
    } else {
      this.openSnackBar('Verifique se as Informações inseridas!', 'Fechar');
    }
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }

  getHintMessage(formField): string {
    if (formField === 'code'){
      return 'Insira um código (de um ERP, por exemplo).';
    } else if (formField === 'name') {
      if (this.name.invalid === true) {
        return 'Nome é Necessário.';
      }
      return 'Insira o nome do Cliente.';
    }
  }
}
