import { Participantes } from '../../../../model/Participantes';
import { ParticipantesService } from '../../../../services/participantes.service';
import { Alertas } from '../../../../util/alertas';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-catalogo-categorias',
  templateUrl: './participantes.component.html',
  styleUrls: ['./participantes.component.css']
})
export class ParticipantesComponent implements OnInit {

  public displayedColumns: String[] = ['Nombre', 'apellidoPaterno','apellidoMaterno','idRool', 'Acciones'];
  public isLoading = false;
  public dataSource: MatTableDataSource<Participantes> = new MatTableDataSource();

  constructor(private router: Router, private service: ParticipantesService) { }
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

  public formulario(id: any): void {
    this.router.navigate(['participantes-Form', id]);
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
