import { catchError, map, throwError, Observable } from 'rxjs';
import { Alertas } from './../util/alertas';
import { Servicios } from './../model/servicios';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  ///constructor() { }
 /* private api = environment.API.SERVICIOS;

  constructor(private http: HttpClient) { }

  public getServiciosAll(): Observable<Servicios[]> {
    return this.http.get<Servicios[]>(this.api.ENDPOINT_SERVICIOS_CRUD).pipe(
      map((response: any) => response.data as Servicios[]),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public show(id: any): Observable<Servicios> {
    return this.http.get<any>(this.api.ENDPOINT_SERVICIOS_CRUD + id).pipe(
      map((response: any) => response.data as Servicios),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener el registro");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public guardar(archivo: File, servicios: Servicios): Observable<Servicios> {
    console.log('ARCHIVO : ' + archivo);
    console.log('RESPONSE SERVICIO: ' + JSON.stringify(servicios));
    let formData = new FormData();
    formData.append("filenames", archivo);
    formData.append('servicios', JSON.stringify(servicios))

    return this.http.post<Servicios>(this.api.ENDPOINT_SERVICIOS_CRUD, formData).pipe(
      map((response: any) => response.data as Servicios),
      catchError(e => {
        Alertas.error("Algo salió mal.", "Error al guardar registro.");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public eliminar(id: number): Observable<boolean> {
    return this.http.delete(this.api.ENDPOINT_SERVICIOS_CRUD + id).pipe(
      map((response: any) => response.Response as boolean),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo eliminar el registro.");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public eliminarImagenes(id: number): Observable<boolean> {
//    console.log('REQUEST..............: ' + this.api.ENDPOINT_ELIMINAR_IMAGENES + id);
    return this.http.delete(this.api.ENDPOINT_ELIMINAR_IMAGENES + id).pipe(
      map((response: any) => response.Response as boolean),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo eliminar el registro.");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }*/

}
