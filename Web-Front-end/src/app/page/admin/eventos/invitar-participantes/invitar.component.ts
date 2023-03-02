import { InvitacionService } from './../../../../services/invitacion.service';
import { Participantes } from './../../../../model/Participantes';
import { ParticipantesService } from './../../../../services/participantes.service';
import { Alertas } from './../../../../util/alertas';
import { Invitacion } from './../../../../model/Invitacion';
import { Validador } from '../../../../util/validador';
import { Router, ActivatedRoute } from '@angular/router';
import { UntypedFormGroup, UntypedFormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contactos-admin',
  templateUrl: './invitar.component.html',
  styleUrls: ['./invitar.component.css']
})
export class InvitarComponent implements OnInit {


  public formulario: UntypedFormGroup = new UntypedFormGroup({});
  public listaContacto: Invitacion[] = [];
  public listaParticipantes: Participantes[] = [];
  public entity: Invitacion = new Invitacion();
  private id!: number;
  public componenteActivo: boolean = true;
  public validadorPhone = Validador.keyPressPhone;
  public validadorNumeros = Validador.keyPressNumbers;
  public validationMessages = Validador.validationMessages;




  constructor(private routers: Router,
    private router: ActivatedRoute,
    private service: InvitacionService,
    private serviceParticipante: ParticipantesService
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.getParametro();
  }

  private initForm(): void {
    this.formulario = new UntypedFormGroup({
      notas: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
      idParticipante: new UntypedFormControl(null, [Validators.minLength(1), Validators.required]),
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
      this.obtener();
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

   const arrayObj: any = [
      {
        idParticipante: {
          id: this.formulario.value.idParticipante.id
        },
        idEvento: {
          id: this.id
        },
        fecha: null,
        asistencia: false
      }
    ];
    this.entity =  arrayObj[0] as Invitacion;

    //if (this.entity.id == 0) {
    this.service.guardar(this.entity!).subscribe((data: any) => {
      this.regresar();
      Alertas.success("Operacion Exitosa", data);
    });
    /* } else {
      this.service.actualizar(this.entity!).subscribe((data: any) => {
        this.regresar();
        Alertas.success("Operacion Exitosa", data);
      });*/
    //}
  }


  public obtener(): void {
    //this.isLoading = true;
    this.serviceParticipante.obtener().subscribe(data => {
      console.log('RESPONSE: ' + JSON.stringify(data));
      this.listaParticipantes = data;
      // this.isLoading = false;
    });
  }


}
