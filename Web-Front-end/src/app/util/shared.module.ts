import { PhonePipe } from './../pipes/phone.pipe';
//import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
//import { FormsModule } from '@angular/forms';
//import { CustomerComponent } from './customer.component';
//import { NewItemDirective } from './new-item.directive';
//import { OrdersPipe } from './orders.pipe';

@NgModule({
  imports: [],
  declarations: [PhonePipe],
  exports: [PhonePipe]
})
export class SharedModule { }
