import { Router, ActivatedRoute } from '@angular/router';
import { Contacto } from '../model/Invitacion';
export class StringUtil {


  public static getDireccion(contacto: Contacto): string {
    return contacto.colonia + ", " + contacto.calle + ", No. Int: " +
      contacto.numeroInterior + ", No. Ext: " + contacto.numeroExterior + ", " +
      contacto.codigoPostal + ", " + contacto.municipio + ", " + contacto.estado + ".";
  }


  private getParametro(router: ActivatedRoute): void {
    router.paramMap.subscribe((paramMap: any) => {
      const { params } = paramMap
      console.log('ID PARAMETRO GET: ' + params.id);
     /* this.id = params.id;
      if (this.id != null && this.id > 0) {
        this.condultarProducyoById();
      } else {
        this.formulario.reset();
      }*/
    })
  }

}
