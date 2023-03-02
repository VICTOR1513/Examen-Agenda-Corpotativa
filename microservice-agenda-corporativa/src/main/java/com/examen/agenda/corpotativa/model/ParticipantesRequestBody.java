package com.examen.agenda.corpotativa.model;

import com.examen.agenda.corpotativa.utils.Constantes;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParticipantesRequestBody {

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer id;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String nombre;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String apellidoPaterno;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String apellidoMaterno;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer idRool;

}
