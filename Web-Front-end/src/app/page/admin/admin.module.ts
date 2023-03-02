import { ListaParticipantesComponent } from './eventos/lista-Participantes/lista-participantes.component';
import { InvitarComponent } from './eventos/invitar-participantes/invitar.component';
import { ProductosFormComponent } from './eventos/eventos-form/eventos-form.component';
import { ParticipantesFormComponent } from './participantes/participantes-form/participantes-form.component';
import { ParticipantesComponent } from './participantes/participantes/participantes.component';
import { EventosComponent } from './eventos/eventos/eventos.component';
import { SharedModule } from './../../util/shared.module';
import { Validador } from './../../util/validador';
import { PhonePipe } from './../../pipes/phone.pipe';
import { SafePipe } from './../../pipes/safe.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminRoutingModule } from './admin-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardAdminComponent } from './dashboard-admin/dashboard-admin.component';
import { HeaderAdminComponent } from './header-admin/header-admin.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
/*ANGULAR MATERIAL*/
import { ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import { FooterComponent } from './footer/footer.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatDividerModule } from '@angular/material/divider';
import {MatDatepickerModule} from '@angular/material/datepicker';

@NgModule({
  declarations: [
    EventosComponent,
    DashboardAdminComponent,
    HeaderAdminComponent,
    HomeAdminComponent,
    InvitarComponent,
    ProductosFormComponent,
    FooterComponent,
    SafePipe,
    //PhonePipe,
    ParticipantesComponent,
    ParticipantesFormComponent,
    ListaParticipantesComponent,
    ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatTableModule,
    MatButtonModule,
    MatSidenavModule,
    MatSelectModule,
    MatCardModule,
    MatInputModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatRadioModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatGridListModule,
    MatDividerModule,
    SharedModule,
    MatDatepickerModule
    //BrowserAnimationsModule
  ]
})
export class AdminModule { }
