package com.agenda.corporativa.model;

import java.util.List;

import com.agenda.corporativa.utils.Constantes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfirmacionRequestBody {

	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer idPais;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer idCanal;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer idSucursal;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer numeroSolicitud;
//	private Integer idTipoSolicitud;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String idDispositivo;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private String numeroEmpleadoConfirma;
	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
	private Integer saldoConfirmado;
//	@NotNull(message = Constantes.FORMATO_INVALIDO_BLANK)
//	@Valid
//	private List<ContenedoresModel> contenedores;

}
