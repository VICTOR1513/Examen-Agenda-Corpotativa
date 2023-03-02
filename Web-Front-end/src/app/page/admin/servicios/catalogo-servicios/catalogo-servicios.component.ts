import { Alertas } from './../../../../util/alertas';
import { ServicioService } from './../../../../services/servicio.service';
import { environment } from './../../../../../environments/environment';
import { MatPaginator } from '@angular/material/paginator';
import { Servicios } from './../../../../model/servicios';
import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-catalogo-servicios',
  templateUrl: './catalogo-servicios.component.html',
  styleUrls: ['./catalogo-servicios.component.css']
})
export class CatalogoServiciosComponent implements OnInit {

  public displayedColumns: String[] = ['Imagen', 'Nombre', 'Descripcion', 'Acciones'];
  public isLoading = false;
  public dataSource: MatTableDataSource<Servicios> = new MatTableDataSource();

  /*constructor() { }

  ngOnInit(): void {
  }*/


  constructor(private router: Router, private service: ServicioService) { }
  @ViewChild('paginator') paginator!: MatPaginator;

  ngOnInit(): void {
 //   this.getListaProductosRelacionados();
  }

 /* public getListaProductosRelacionados(): void {
    this.isLoading = true;
    this.service.getServiciosAll().subscribe(servicios => {
      servicios.forEach(servicio => {
        servicio.idCatalogoImagenes.forEach(i => {
          i.urlImagen = environment.URL_BASE_BACKEND + i.urlImagen;
        });
        servicio.urlImagen = servicio.idCatalogoImagenes[0] !==undefined ? servicio.idCatalogoImagenes[0].urlImagen : "" ;
      });
      //console.log('RESPONSE: ' + JSON.stringify(productos));
      this.dataSource = new MatTableDataSource(servicios);
      this.dataSource.paginator = this.paginator;
      this.isLoading = false;
    });
  }


  public formProductos(id: any): void {
    this.router.navigate(['Admin/Dashboard/Servicios-Form', id]);
  }

  public eliminar(entity: any) {
    Alertas.confirmar("¿Eliminar registro?", "Se eliminara el registro" + entity.nombre).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(entity.id).subscribe((data: any) => {
          this.getListaProductosRelacionados();
          Alertas.success("Eliminado", "El registro fue eliminado correctamente.");
        });
      }
    });
  }*/


}
