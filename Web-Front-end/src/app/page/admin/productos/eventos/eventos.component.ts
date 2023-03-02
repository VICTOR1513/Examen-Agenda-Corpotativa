import { Eventos } from '../../../../model/eventos';
import { EventosService } from '../../../../services/eventos.service';
import { Alertas } from '../../../../util/alertas';
import { Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-catalogo-productos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent implements OnInit {

  public displayedColumns: String[] = ['Nombre', 'Cupo','FechaInicio','FechaFin', 'Acciones'];
  public isLoading = false;
  public dataSource: MatTableDataSource<Eventos> = new MatTableDataSource();

  constructor(private router: Router, private service: EventosService) { }
  @ViewChild('paginator') paginator!: MatPaginator;

  ngOnInit(): void {
    this.obtener();
  }

  public obtener(): void {
    this.isLoading = true;
    this.service.obtener().subscribe(evento => {
      console.log('RESPONSE: ' + JSON.stringify(evento));
      this.dataSource = new MatTableDataSource(evento);
      this.dataSource.paginator = this.paginator;
      this.isLoading = false;
    });
  }

  public eventosForm(id: any): void {
    this.router.navigate(['eventos-Form', id]);
  }

  public eliminar(entity: any) {
    Alertas.confirmar("¿Eliminar registro?", "Se eliminara el registro" + entity.nombre).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(entity.id).subscribe((data: any) => {
          this.obtener();
          Alertas.success("Eliminado", data);
        });
      }
    });
  }

}
