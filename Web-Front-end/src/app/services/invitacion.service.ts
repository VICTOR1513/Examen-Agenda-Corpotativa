import { Invitacion } from './../model/Invitacion';
import { environment } from '../../environments/environment';
import { Alertas } from '../util/alertas';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, pluck, map, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InvitacionService {

  private api = environment.API.INVITACION;

  constructor(private http: HttpClient) { }

  public obtener(): Observable<Invitacion[]> {
    console.log('URL: ' + JSON.stringify(this.api.OBTENER));
    return this.http.get<Invitacion[]>(this.api.OBTENER).pipe(
      map((response: any) => response.resultado as Invitacion[]),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public consultarId(id: number): Observable<Invitacion> {
    return this.http.get<Invitacion>(this.api.OBTENER_BY_ID + id).pipe(
      map((response: any) => response.resultado as Invitacion),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener el producto");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public consultarIdEvento(id: number): Observable<Invitacion[]> {
    console.log('URL: ' + JSON.stringify(this.api.OBTENER_BY_ID_EVENTO + id));
    return this.http.get<Invitacion[]>(this.api.OBTENER_BY_ID_EVENTO + id).pipe(
      map((response: any) => response.resultado as Invitacion[]),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public guardar(entity: Invitacion): Observable<string> {
    console.log('POST JSON : ' + JSON.stringify(entity));
    return this.http.post<string>(this.api.GUARDAR, entity).pipe(
      map((response: any) => response.resultado as string),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo guardar el registro");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public actualizar(entity: Invitacion): Observable<string> {
    return this.http.put<string>(this.api.ACTUALIZAR, entity).pipe(
      map((response: any) => response.resultado as string),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo guardar el registro");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

  public eliminar(id: number): Observable<string> {
    return this.http.delete(this.api.ELIMINAR + id).pipe(
      map((response: any) => response.resultado as string),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo eliminar el registro.");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

}
