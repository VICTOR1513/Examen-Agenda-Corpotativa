import { Eventos } from './../model/eventos';
import { environment } from './../../environments/environment';
import { Alertas } from './../util/alertas';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, Observable, pluck, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventosService {

  private api = environment.API.EVENTOS;

  constructor(private http: HttpClient) { }

  public obtener(): Observable<Eventos[]> {
    console.log('URL: ' + JSON.stringify(this.api.OBTENER));
    return this.http.get<Eventos[]>(this.api.OBTENER).pipe(
      map((response: any) => response.resultado as Eventos[]),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public consultarId(id: number): Observable<Eventos> {
    return this.http.get<Eventos>(this.api.OBTENER_BY_ID + id).pipe(
      map((response: any) => response.resultado as Eventos),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener el producto");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public guardar(entity: Eventos): Observable<string> {
    console.log('RESPONSE JSON : ' + JSON.stringify(entity));
    return this.http.post<string>(this.api.GUARDAR, entity).pipe(
      map((response: any) => response.resultado as string),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo guardar el registro");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public actualizar(entity: Eventos): Observable<string> {
    return this.http.put<string>(this.api.ACTUALIZAR, entity).pipe(
      map((response: any) => response.resultado as string),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo guardar el registro");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public eliminar(id: number): Observable<string> {
    return this.http.delete(this.api.ELIMINAR + id).pipe(
      map((response: any) => response.resultado as string),
      catchError(e => {
        Alertas.error("Algo salió mal", "El evento tiene participantes asignados, No se pudo eliminar el registro.");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }




}
