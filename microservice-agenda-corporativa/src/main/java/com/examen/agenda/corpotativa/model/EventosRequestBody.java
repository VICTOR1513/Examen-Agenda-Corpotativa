package com.examen.agenda.corpotativa.model;

import com.examen.agenda.corpotativa.utils.Constantes;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventosRequestBody {

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer id;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String nombre;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer cupo;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String fechaInicio;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String fechaFin;

//	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
//	private Integer numeroSolicitud;
////	private Integer idTipoSolicitud;
//	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
//	private String idDispositivo;
//	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
//	private String numeroEmpleadoConfirma;
//	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
//	private Integer saldoConfirmado;
//	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
//	@Valid
//	private List<ContenedoresModel> contenedores;

}
