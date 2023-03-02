import { ListaParticipantesComponent } from './eventos/lista-Participantes/lista-participantes.component';
import { InvitarComponent } from './eventos/invitar-participantes/invitar.component';
import { ParticipantesComponent } from './participantes/participantes/participantes.component';
import { ParticipantesFormComponent } from './participantes/participantes-form/participantes-form.component';
import { ProductosFormComponent } from './eventos/eventos-form/eventos-form.component';
import { EventosComponent } from './eventos/eventos/eventos.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { Routes, RouterModule } from '@angular/router';
import { DashboardAdminComponent } from './dashboard-admin/dashboard-admin.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

const routes: Routes = [
  {
    path: '',
    component: DashboardAdminComponent,
    children: [
      { path: '', redirectTo: 'Home', pathMatch: 'full' },
      { path: 'eventos', component: EventosComponent },
      { path: 'eventos-Form/:id', component: ProductosFormComponent },
      { path: 'Home', component: HomeAdminComponent },
      { path: 'lista-participantes/:id', component: ListaParticipantesComponent },
      { path: 'invitar-participantes/:id', component: InvitarComponent },
      { path: 'participantes', component: ParticipantesComponent },
      { path: 'participantes-Form/:id', component: ParticipantesFormComponent },
    ],
  },
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],

})
export class AdminRoutingModule { }
