import { Validador } from './../../../util/validador';
import { Alertas } from './../../../util/alertas';
import { Contacto } from './../../../model/contacto';
import { ContactoService } from './../../../services/contacto.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UntypedFormGroup, UntypedFormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contactos-admin',
  templateUrl: './contactos-admin.component.html',
  styleUrls: ['./contactos-admin.component.css']
})
export class ContactosAdminComponent implements OnInit {


  public formulario: UntypedFormGroup = new UntypedFormGroup({});
  public listaContacto: Contacto[] = [];
  public entity: Contacto = new Contacto();
  private id!: number;
  public componenteActivo: boolean = true;
  public validadorPhone = Validador.keyPressPhone;
  public validadorNumeros = Validador.keyPressNumbers;
  public validationMessages = Validador.validationMessages;

  constructor(private routers: Router,
    private router: ActivatedRoute,
    private service: ContactoService,
  ) { }

  ngOnInit(): void {
  /*  this.initForm();
    this.getListaContactos();*/
  }

 /* private initForm(): void {
    this.formulario = new UntypedFormGroup({
      correo: new UntypedFormControl(null, [Validators.minLength(1), Validators.required, Validators.pattern(Validador.emailRegExp)]),
      telefono1: new UntypedFormControl(null, [Validators.required, Validators.pattern("^[0-9]*$"), Validators.minLength(10), Validators.maxLength(10)]),
      telefono2: new UntypedFormControl(null, [Validators.required, Validators.pattern("^[0-9]*$"), Validators.minLength(10), Validators.maxLength(10)]),
      telefono3: new UntypedFormControl(null, [Validators.required, Validators.pattern("^[0-9]*$"), Validators.minLength(10), Validators.maxLength(10)]),
      codigoPostal: new UntypedFormControl(null, [Validators.required, Validators.pattern(Validador.numberRegEx)]),
      estado: new UntypedFormControl(null, [Validators.required]),
      municipio: new UntypedFormControl(null, [Validators.required]),
      colonia: new UntypedFormControl(null, [Validators.required]),
      calle: new UntypedFormControl(null, [Validators.required]),
      numeroExterior: new UntypedFormControl(null, [Validators.required]),
      numeroInterior: new UntypedFormControl(null, [Validators.required]),
      ubucacion: new UntypedFormControl(null, [Validators.required]),
    });
    this.formulario.disable();
  }

  public guardar(): void {
    this.entity = this.formulario.value;
    this.entity.id = this.id;
    this.service.guardar(this.entity).subscribe(contacto => {
      this.entity = contacto;
      console.log('RESPONSE AL GUARDAR COMPONENT : ' + JSON.stringify(contacto));
      this.getListaContactos();
      this.resetForm();
      Alertas.success("Operacion Exitosa", "El registro se guardo corectamente");
    });
  }

  public condultarContactoById(entity: Contacto): void {
    if (entity.activo) {
      this.service.getContactoById(entity.id).subscribe(contacto => {
        this.entity = contacto;
        this.id = contacto.id;
        console.log('RESPONSE CONTACTO: ' + JSON.stringify(this.entity));
        this.setDatos();
      });
    }
  }

  private getListaContactos(): void {
    this.service.obtenerContactos().subscribe(listaContacto => {
      this.listaContacto = listaContacto;
    });
  }

  private setDatos(): void {
    this.formulario.patchValue(this.entity);
    this.componenteActivo = false;
    this.formulario.enable();
  }

  public eliminar(entity: Contacto): void {
    if (entity.activo) {
      Alertas.confirmar("¿Eliminar  registro?", "Se eliminara el registro seleccionado.").then((result) => {
        if (result.isConfirmed) {
          this.service.eliminar(entity.id).subscribe(respuesta => {
            console.log("ELIMINADO RESPUESTA: " + respuesta);
            if (respuesta) {
              this.getListaContactos();
              Alertas.success("Eliminado", "El registro fue eliminado correctamente.");
            } else {
              Alertas.error("Algo salió mal", "No se pudo eliminar el registro.");
            }
          });
        }
      });
    }
  }

  public desablilitar(entity: Contacto): void {
    let habilitar = !entity.activo;
    Alertas.confirmar(habilitar ? "¿Habilitar registro?" : "¿Desabilitar registro?", "Se desabilitara el registro seleccionado.").then((result) => {
      if (result.isConfirmed) {
        this.service.desablilitar(entity.id, habilitar).subscribe(respuesta => {
          console.log("DESABILITAR RESPUESTA: " + respuesta);
          if (respuesta) {
            this.getListaContactos();
            this.resetForm();
            Alertas.success(habilitar ? "Habilitado" : "Desabilitado", habilitar ? "El registro fue habilitado correctamente." : "El registro fue desabilitado correctamente.");
          } else {
            Alertas.error("Algo salió mal", "No se pudo desabilitar el registro.");
          }
        });
      }
    });
  }

  private resetForm(): void {
    this.formulario.disable();
    this.formulario.reset();
  }

  public disableAll(): boolean {
    this.listaContacto.forEach

    return false;
  }*/


}
