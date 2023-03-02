import { Participantes } from './../../../../model/Participantes';
import { ParticipantesService } from './../../../../services/participantes.service';
import { Alertas } from '../../../../util/alertas';
import { UntypedFormGroup, UntypedFormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categorias-form',
  templateUrl: './categorias-form.component.html',
  styleUrls: ['./categorias-form.component.css']
})
export class CategoriasFormComponent implements OnInit {

  public formulario: UntypedFormGroup = new UntypedFormGroup({});
  public entity: Participantes = new Participantes();
  private id!: number;

  constructor(private routers: Router, private router: ActivatedRoute, private service: ParticipantesService) { }

  ngOnInit(): void {
    /*this.initForm();
    this.getParametro();*/
  }

  /*private getParametro(): void {
    this.router.paramMap.subscribe((paramMap: any) => {
      const { params } = paramMap
      console.log('ID PARAMETRO GET: ' + params.id);
      this.id = params.id;
      if (this.id != null && this.id > 0) {
        this.condultarCategoriaById();
      } else {
        this.formulario.reset();
      }
    })
  }

  private initForm(): void {
    this.formulario = new UntypedFormGroup({
      nombre: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      descripcion: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
    });
  }

  public regresar(): void {
    this.routers.navigate(['Admin/Dashboard/Catalogo-Categorias']);
  }

  private condultarCategoriaById(): void {
    this.service.show(this.id).subscribe(categorias => {
      this.entity = categorias;
      console.log('RESPONSE: ' + JSON.stringify(this.entity));
      this.setDatos();
    });
  }

  private setDatos(): void {
    this.formulario.patchValue(this.entity);
  }

  public guardar(): void {
    this.entity = this.formulario.value;
    this.entity.id = this.id;
    //this.entity.aplicativo = Constantes.APLICATIVO;
    this.service.save(this.entity!).subscribe((data: any) => {
      console.log('RESPONSE AL GUARDAR COMPONENT : ' + JSON.stringify(data));
      this.regresar();
      Alertas.success("Operacion Exitosa", "El registro se guardo corectamente");
    });
  }*/

}
