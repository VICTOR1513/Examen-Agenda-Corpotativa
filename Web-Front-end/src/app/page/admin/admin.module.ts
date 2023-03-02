import { SharedModule } from './../../util/shared.module';
import { Validador } from './../../util/validador';
import { PhonePipe } from './../../pipes/phone.pipe';
import { SafePipe } from './../../pipes/safe.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminRoutingModule } from './admin-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {  EventosComponent } from './productos/eventos/eventos.component';
import { DashboardAdminComponent } from './dashboard-admin/dashboard-admin.component';
import { HeaderAdminComponent } from './header-admin/header-admin.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { ContactosAdminComponent } from './contactos-admin/contactos-admin.component';
import { CatalogoUsuariosComponent } from './catalogo-usuarios/catalogo-usuarios.component';
import { ProductosFormComponent } from './productos/eventos-form/eventos-form.component';
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
import { CatalogoCategoriasComponent } from './categorias/participantes/catalogo-categorias.component';
import { CategoriasFormComponent } from './categorias/participantes-form/categorias-form.component';
import { CatalogoServiciosComponent } from './servicios/catalogo-servicios/catalogo-servicios.component';
import { CatalogoServiciosFormComponent } from './servicios/catalogo-servicios-form/catalogo-servicios-form.component';
import {MatDatepickerModule} from '@angular/material/datepicker';

@NgModule({
  declarations: [
    EventosComponent,
    DashboardAdminComponent,
    HeaderAdminComponent,
    HomeAdminComponent,
    ContactosAdminComponent,
    CatalogoUsuariosComponent,
    ProductosFormComponent,
    FooterComponent,
    SafePipe,
    //PhonePipe,
    CatalogoCategoriasComponent,
    CategoriasFormComponent,
    CatalogoServiciosComponent,
    CatalogoServiciosFormComponent
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
