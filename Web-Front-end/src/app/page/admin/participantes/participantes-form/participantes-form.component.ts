import { Participantes } from '../../../../model/Participantes';
import { ParticipantesService } from '../../../../services/participantes.service';
import { Alertas } from '../../../../util/alertas';
import { UntypedFormGroup, UntypedFormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categorias-form',
  templateUrl: './participantes-form.component.html',
  styleUrls: ['./participantes-form.component.css']
})
export class ParticipantesFormComponent implements OnInit {

  public formulario: UntypedFormGroup = new UntypedFormGroup({});
  public entity: Participantes = new Participantes();
  private id!: number;

  constructor(private routers: Router, private router: ActivatedRoute, private service: ParticipantesService) { }

  ngOnInit(): void {
    this.initForm();
    this.getParametro();
  }

  private initForm(): void {
    this.formulario = new UntypedFormGroup({
      nombre: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      cupo: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      apellidoPaterno: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      apellidoMaterno: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      idRool: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),

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
    this.routers.navigate(['participantes']);
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
