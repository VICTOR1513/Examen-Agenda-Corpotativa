import { NotFoundComponent } from './page/not-found/not-found.component';
//import { InicioComponent } from './page/public/inicio/inicio.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


const routes: Routes = [
  /*{
    path: '',
    loadChildren: () =>
      import('./page/public/public.module').then(m => m.PublicModule),
  },*/
  {
    path: '',
    loadChildren: () =>
      import('./page/admin/admin.module').then(m => m.AdminModule),
  },
  { path: '**', component: NotFoundComponent },
];



@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
