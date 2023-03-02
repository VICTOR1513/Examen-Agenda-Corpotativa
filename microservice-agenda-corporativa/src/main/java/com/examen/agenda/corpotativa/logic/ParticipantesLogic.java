package com.examen.agenda.corpotativa.logic;

import java.util.List;

import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.model.ParticipantesRequestBody;

public interface ParticipantesLogic {

	public GenericResponse<List<ParticipantesRequestBody>> obtener()
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<ParticipantesRequestBody> obtenerPorId(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<String> guardar(ParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<String> actualizar(ParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<String> eliminar(Integer id) throws HttpServerErrorException, ArgumentNotValidException;
}
