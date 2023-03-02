import { environment } from './../../../../../environments/environment';
import { Alertas } from './../../../../util/alertas';
import { ServicioService } from './../../../../services/servicio.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Servicios } from './../../../../model/servicios';
import { UntypedFormGroup, Validators, UntypedFormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-catalogo-servicios-form',
  templateUrl: './catalogo-servicios-form.component.html',
  styleUrls: ['./catalogo-servicios-form.component.css']
})
export class CatalogoServiciosFormComponent implements OnInit {

  public formulario: UntypedFormGroup = new UntypedFormGroup({});
  public entity: Servicios = new Servicios();
  public fotoSeleccionada?: File;
  public urlImagen: any;
  private id: any;

  constructor(private routers: Router, private router: ActivatedRoute, private service: ServicioService) { }

  ngOnInit(): void {
   /* this.initForm();
    this.getParametro();*/
  }
/*
  private initForm(): void {
    this.formulario = new UntypedFormGroup({
      nombre: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      descripcion: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),

    });
  }

  private getParametro(): void {
    this.router.paramMap.subscribe((paramMap: any) => {
      const { params } = paramMap
      console.log('ID PARAMETRO GET: ' + params.id);
      this.id = params.id;
      if (this.id != null && this.id > 0) {
        this.condultarProducyoById();
      } else {
        this.formulario.reset();
      }
    })
  }


  private condultarProducyoById(): void {
    this.service.show(this.id).subscribe(objecto => {
      this.entity = objecto;
      this.entity.idCatalogoImagenes.forEach(imagenes => {
        imagenes.urlImagen = environment.URL_BASE_BACKEND + imagenes.urlImagen;
      });

      console.log('RESPONSE JSON FINAL PRODUCTO: ' + JSON.stringify(objecto));
      this.setDatos();
    });
  }

  private setDatos(): void {
    this.formulario.patchValue(this.entity);
  }



  public guardar(): void {
    this.entity = this.formulario.value;
    this.entity.id = this.id;
    this.service.guardar(this.fotoSeleccionada!, this.formulario.value).subscribe((data: any) => {
      console.log('RESPONSE AL GUARDAR COMPONENT : ' + JSON.stringify(data));
      this.regresar();
      Alertas.success("Operacion Exitosa", "El registro se guardo corectamente");
    });
  }

  public seleccionarImagen(event: any) {
    this.fotoSeleccionada = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(this.fotoSeleccionada!);
    reader.onload = (_event) => {
      this.urlImagen = reader.result;
    }
  }

  public regresar(): void {
    this.routers.navigate(['Admin/Dashboard/Catalogo-Servicios']);
  }


  public eliminarImegenes(id: number) {
    Alertas.confirmar("¿Eliminar registro?", "Se eliminara la imagen").then((result) => {
      if (result.isConfirmed) {
        this.service.eliminarImagenes(id).subscribe((data: boolean) => {
          this.getParametro();
          if (!data) {
            Alertas.error("Algo salió mal", "No se pudo eliminar la imagen.");
          } else {
            Alertas.success("Eliminado", "La imagen fue eliminada correctamente.");
          }
        });
      }
    });
  }*/




}
