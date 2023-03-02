package com.agenda.corporativa.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SpSolicitud {

	private Integer FIIDTIPODISPOSITIVO;
	private String FCNOMDISPOSITIVO;
	private String FCIDDISPOSITIVO;
	private Integer FCEMPLEADODISP;
	private Integer FIIDTIPOSOLICITUD;
	private String FCTIPOSOLICITUD;
	private Integer FIIDSOLICITUDOPERA;
	private String FCSOLICITUDOPERA;
	private Integer FNNUMSOLICITUD;
	private Integer FIIDDIVISA;
	private String FCABREVIATURA;
	private Integer FIIDESTATUS;
	private String FCNOMESTATUS;
	private BigDecimal FNSALDOSOLICITADO;
	private String FDFECHASOLICITUD;
	private String FDFECHAAUTORIZA;
	private Integer FCEMPLEADOAUTORIZA;
	private Integer FCEMPLEADO;
	private Integer FIIDOPERACIONORIGEN;
	private String FCOPERACIONORIGEN;

}
