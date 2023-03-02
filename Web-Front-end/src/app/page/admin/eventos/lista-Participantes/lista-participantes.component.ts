import { InvitacionService } from './../../../../services/invitacion.service';
import { Invitacion } from './../../../../model/Invitacion';
import { Alertas } from '../../../../util/alertas';
import { Router, ActivatedRoute } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-catalogo-categorias',
  templateUrl: './lista-participantes.component.html',
  styleUrls: ['./lista-participantes.component.css']
})
export class ListaParticipantesComponent implements OnInit {

  public displayedColumns: String[] = ['Nombre', 'apellidoPaterno','apellidoMaterno','Evento','EstatusAsistencia', 'Acciones'];
  public isLoading = false;
  public dataSource: MatTableDataSource<Invitacion> = new MatTableDataSource();
  private id: any;

  constructor(private routers: Router, private router: ActivatedRoute, private service: InvitacionService) { }
  @ViewChild('paginator') paginator!: MatPaginator;

  ngOnInit(): void {
    this.getParametro();
   // this.obtener();
  }

  private getParametro(): void {
    this.router.paramMap.subscribe((paramMap: any) => {
      const { params } = paramMap
      console.log('ID PARAMETRO GET: ' + params.id);
      this.id = params.id;
      if (this.id != null && this.id > 0) {
        this.obtenerPorIdEvento();
      } else {
        //this.formulario.reset();
      }
    })
  }


  public obtenerPorIdEvento(): void {
    this.isLoading = true;
    this.service.consultarIdEvento(this.id).subscribe(data => {
      data.forEach(invitacion =>invitacion.estatusAsistencia =  invitacion.asistencia ? "Asistencia confirmada" : "Asistencia no confirmada" );
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.isLoading = false;
    });
  }


/*
  public formulario(id: any): void {
    this.routers.navigate(['participantes-Form', id]);
  }*/

  public regresar(): void {
    this.routers.navigate(['eventos']);
  }

  public eliminar(entity: any) {
    Alertas.confirmar("¿Eliminar registro?", "Se eliminara el registro" + entity.nombre).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(entity.id).subscribe((data: any) => {
          this.obtenerPorIdEvento();
          Alertas.success("Eliminado", data);
        });
      }
    });
  }

}
