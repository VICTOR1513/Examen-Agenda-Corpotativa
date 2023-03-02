import { Alertas } from './../../../../util/alertas';
import { Eventos } from '../../../../model/eventos';
import { EventosService } from '../../../../services/eventos.service';
import { Validators, UntypedFormControl, UntypedFormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-productos-form',
  templateUrl: './eventos-form.component.html',
  styleUrls: ['./eventos-form.component.css']
})
export class ProductosFormComponent implements OnInit {

  public formulario: UntypedFormGroup = new UntypedFormGroup({});
  public entity: Eventos = new Eventos();
  //public categorias!: Categoria[];
  private id: any;
  //public fotoSeleccionada?: File;
  //public urlImagen: any;

  constructor(private routers: Router, private router: ActivatedRoute, private service: EventosService) { }

  ngOnInit(): void {
    this.initForm();
    this.getParametro();
  }

  private initForm(): void {
    this.formulario = new UntypedFormGroup({
      nombre: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      cupo: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      fechaInicio: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      fechaFin: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
    });
  }

  private getParametro(): void {
    this.router.paramMap.subscribe((paramMap: any) => {
      const { params } = paramMap
      console.log('ID PARAMETRO GET: ' + params.id);
      this.id = params.id;
      if (this.id != null && this.id > 0) {
        this.consultarId();
      } else {
        this.formulario.reset();
      }
    })
  }

  private consultarId(): void {
    this.service.consultarId(this.id).subscribe(objecto => {
      this.entity = objecto;
      console.log('RESPONSE JSON FINAL PRODUCTO: ' + JSON.stringify(objecto));
      this.setDatos();
    });
  }

  private setDatos(): void {
    this.formulario.patchValue(this.entity);
  }

  public regresar(): void {
    this.routers.navigate(['eventos']);
  }

  public guardar(): void {
    this.entity = this.formulario.value;
    this.entity.id = this.id;
    if (this.entity.id == 0) {
      this.service.guardar(this.entity!).subscribe((data: any) => {
        this.regresar();
        Alertas.success("Operacion Exitosa", data);
      });
    } else {
      this.service.actualizar(this.entity!).subscribe((data: any) => {
        this.regresar();
        Alertas.success("Operacion Exitosa", data);
      });
    }
  }


}
