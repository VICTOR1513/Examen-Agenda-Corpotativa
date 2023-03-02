package com.examen.agenda.corpotativa.logic;

import java.util.List;

import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.model.EventoAsParticipantesRequestBody;
import com.examen.agenda.corpotativa.model.GenericResponse;

public interface EventoAsParticipantesLogic {

	public GenericResponse<List<EventoAsParticipantesRequestBody>> obtener()
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<EventoAsParticipantesRequestBody> obtenerPorId(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException;
	
	public GenericResponse<List<EventoAsParticipantesRequestBody>> obtenerPorIdEvento(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<String> guardar(EventoAsParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<String> actualizar(EventoAsParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException;

	public GenericResponse<String> eliminar(Integer id) throws HttpServerErrorException, ArgumentNotValidException;

}
