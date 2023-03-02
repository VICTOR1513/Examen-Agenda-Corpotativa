import { Participantes } from './../model/Participantes';
import { environment } from '../../environments/environment';
import { Alertas } from '../util/alertas';
import { Observable, map, catchError, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ParticipantesService {

  private api = environment.API.PARTICIPANTES;

  constructor(private http: HttpClient) { }

  public obtener(): Observable<Participantes[]> {
    console.log('URL: ' + JSON.stringify(this.api.OBTENER));
    return this.http.get<Participantes[]>(this.api.OBTENER).pipe(
      map((response: any) => response.resultado as Participantes[]),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener los productos");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public consultarId(id: number): Observable<Participantes> {
    return this.http.get<Participantes>(this.api.OBTENER_BY_ID + id).pipe(
      map((response: any) => response.resultado as Participantes),
      catchError(e => {
        Alertas.error("Algo salió mal", "No se pudo obtener el producto");
        console.error(e.console.error.mensaje);
        return throwError(e);
      })
    );
  }

  public guardar(entity: Participantes): Observable<string> {
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

  public actualizar(entity: Participantes): Observable<string> {
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
        Alertas.error("Algo salió mal", "No se pudo eliminar el registro.");
        console.error(e.console.error.mensaje);
        throw new Error(e);
      })
    );
  }

}
