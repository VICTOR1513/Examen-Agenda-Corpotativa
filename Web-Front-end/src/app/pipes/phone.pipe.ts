import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phone'
})
export class PhonePipe implements PipeTransform {

  transform(value: string): string {
    //return value.replace(/(\d{1})(\d{2})(\d{2})(\d{3})/, '0$1-$2-$3-$4');
    return value.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
  }

}
