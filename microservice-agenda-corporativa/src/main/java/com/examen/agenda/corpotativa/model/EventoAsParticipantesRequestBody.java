package com.examen.agenda.corpotativa.model;

import com.examen.agenda.corpotativa.utils.Constantes;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventoAsParticipantesRequestBody {

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer id;
	
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private ParticipantesRequestBody idParticipante;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private EventosRequestBody idEvento;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer fecha;

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private boolean asistencia;
}
