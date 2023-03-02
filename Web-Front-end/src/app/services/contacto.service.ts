import { environment } from './../../environments/environment';
import { Alertas } from './../util/alertas';
import { Contacto } from '../model/contacto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, pluck, map, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

 /* private api = environment.API.CONTACTOS;

  constructor(private http: HttpClient) { }

  public getContactoOficial(): Observable<Contacto> {
    return this.http.get<Contacto>(this.api.ENDPOINT_CONTACTO_OFICIAL).pipe(
      map((response: any) => response.data as Contacto),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public obtenerContactos(): Observable<Contacto[]> {
    return this.http.get<Contacto[]>(this.api.ENDPOINT_ALL).pipe(
      map((response: any) => response.data as Contacto[]),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public getContactoById(id: any): Observable<Contacto> {
    return this.http.get<any>(this.api.ENDPOINT_BY_ID + id).pipe(
      map((response: any) => response.data as Contacto),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los contactos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public guardar(contacto: Contacto): Observable<Contacto> {
    return this.http.post<Contacto>(this.api.ENDPOINT_SAVE, contacto).pipe(
      map((response: any) => response.data as Contacto),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los contactos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public eliminar(id: number): Observable<boolean> {
    return this.http.delete(this.api.ENDPOINT_DELETE + id).pipe(
      map((response: any) => response.Response as boolean),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo eliminar el registro.");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public desablilitar(id: number, activo: boolean): Observable<boolean> {
    return this.http.delete(this.api.ENDPOINT_DISABLED + id + '/' + activo).pipe(
      map((response: any) => response.Response as boolean),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo desabilitar el registro.");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }*/

}
