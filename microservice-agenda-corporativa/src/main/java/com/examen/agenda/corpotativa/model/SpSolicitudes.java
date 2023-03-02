package com.examen.agenda.corpotativa.model;

import java.util.List;

import lombok.Data;

@Data
public class SpSolicitudes {

	private List<SpSolicitud> solicitudes;
	private List<SpDetalleSolicitud> destallesDenominacion;

}
