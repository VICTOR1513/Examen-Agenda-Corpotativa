export class Validador {

  public static numberRegEx = /\-?\d*\.?\d{1,2}/;
  public static emailRegExp: string = '^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$';

  public static keyPressPhone(event: any) {
    const pattern = /[0-9\+\-\ ]/;
    let inputChar = String.fromCharCode(event.charCode);
    if (event.keyCode != 8 && !pattern.test(inputChar)) {
      event.preventDefault();
    }
  }

  public static keyPressNumbers(event: any) {
    var charCode = (event.which) ? event.which : event.keyCode;
    // Only Numbers 0-9
    if ((charCode < 48 || charCode > 57)) {
      event.preventDefault();
      return false;
    } else {
      return true;
    }
  }

  public static validationMessages() {
    return {
      'username': [
        { type: 'required', message: 'Username is required' },
        { type: 'minlength', message: 'Username must be at least 5 characters long' },
        { type: 'maxlength', message: 'Username cannot be more than 25 characters long' },
        { type: 'pattern', message: 'Your username must contain only numbers and letters' },
        { type: 'validUsername', message: 'Your username has already been taken' }
      ],
      'email': [
        { type: 'required', message: 'El campo es requerido.' },
        { type: 'pattern', message: 'El formato es incorrecto.' }
      ],
      'phone': [
        { type: 'required', message: 'El campo telefono es requerido.' },
        { type: 'pattern', message: 'El formato de telefono es incorrecto.' },
        { type: 'minlength', message: 'Debe ser mayor a 10 cacatreres' },
        { type: 'maxlength', message: 'Debe ser menor a 10 caracteres' }
      ],
      'text': [
        { type: 'required', message: 'El campo es requerido.' },
      ],
      'confirm_password': [
        { type: 'required', message: 'Confirm password is required' },
        { type: 'areEqual', message: 'Password mismatch' }
      ],
      'password': [
        { type: 'required', message: 'Password is required' },
        { type: 'minlength', message: 'Password must be at least 5 characters long' },
        { type: 'pattern', message: 'Your password must contain at least one uppercase, one lowercase, and one number' }
      ],
      'terms': [
        { type: 'pattern', message: 'You must accept terms and conditions' }
      ]
    }
  }

}
