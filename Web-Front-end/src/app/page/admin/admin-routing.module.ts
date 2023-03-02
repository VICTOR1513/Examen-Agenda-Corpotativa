import { CatalogoServiciosFormComponent } from './servicios/catalogo-servicios-form/catalogo-servicios-form.component';
import { CatalogoServiciosComponent } from './servicios/catalogo-servicios/catalogo-servicios.component';
import { CategoriasFormComponent } from './categorias/participantes-form/categorias-form.component';
import { CatalogoCategoriasComponent } from './categorias/participantes/catalogo-categorias.component';
import { ContactosAdminComponent } from './contactos-admin/contactos-admin.component';
import { ProductosFormComponent } from './productos/eventos-form/eventos-form.component';
import { CatalogoUsuariosComponent } from './catalogo-usuarios/catalogo-usuarios.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { EventosComponent } from './productos/eventos/eventos.component';
import { Routes, RouterModule } from '@angular/router';
import { DashboardAdminComponent } from './dashboard-admin/dashboard-admin.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

const routes: Routes = [
  {
    path: '',
    component: DashboardAdminComponent,
    children: [
      /*{ path: '', redirectTo: 'inicio', pathMatch: 'full' },
      { path: 'inicio', component: InicioComponent },
      { path: 'Servicio', component: ServiciosComponent },
      { path: 'Contacto', component: ContactosComponent },
      { path: 'Producto', component: ProductosComponent },
      { path: 'Detalles/:id', component: DetallesComponent },*/
      { path: '', redirectTo: 'inicio', pathMatch: 'full' },

      { path: 'Catalogo-Servicios', component: CatalogoServiciosComponent },
      { path: 'Servicios-Form/:id', component: CatalogoServiciosFormComponent },

      { path: 'eventos', component: EventosComponent },
      { path: 'eventos-Form/:id', component: ProductosFormComponent },
      { path: 'Home', component: HomeAdminComponent },
      { path: 'Catalogo-Usuarios', component: CatalogoUsuariosComponent },
      { path: 'Contactos', component: ContactosAdminComponent },
      { path: 'participantes', component: CatalogoCategoriasComponent },
      { path: 'Form-Categoria/:id', component: CategoriasFormComponent },
    ],
  },
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],

})
export class AdminRoutingModule { }
