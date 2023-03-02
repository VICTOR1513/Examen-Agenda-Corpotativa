import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
//import Swal from 'sweetalert2/dist/sweetalert2.js';
import 'sweetalert2/src/sweetalert2.scss';

export class Alertas {

  public static confirmar(title: string, texto: string) {
    return Swal.fire({
      title: title,
      text: texto,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Aceptar'
    })
  }

  public static success(title: string, mensaje: string): void {
    Swal.fire({
      title: title,
      text: mensaje,
      icon: 'success',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'Aceptar'
    })
  }

  public static error(title: string, mensaje: string): void {
    Swal.fire({
      icon: 'error',
      title: title,
      text: mensaje,
      //footer: '<a href="">Why do I have this issue?</a>'
    })
  }

}
