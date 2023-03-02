package com.examen.agenda.corpotativa.services.impl;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.logic.EventoAsParticipantesLogic;
import com.examen.agenda.corpotativa.model.EventoAsParticipantesRequestBody;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.services.EventoAsParticipantesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EventoAsParticipantesServiceImpl  implements EventoAsParticipantesService {
	
	@Autowired
	private EventoAsParticipantesLogic logic;

	@Override
	public GenericResponse<List<EventoAsParticipantesRequestBody>> obtener()
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<List<EventoAsParticipantesRequestBody>> response = new GenericResponse<>();
		try {
			response = logic.obtener();
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public GenericResponse<EventoAsParticipantesRequestBody> obtenerPorId(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<EventoAsParticipantesRequestBody> response = new GenericResponse<>();
		try {
			response = logic.obtenerPorId(id);
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@Override
	public GenericResponse<List<EventoAsParticipantesRequestBody>> obtenerPorIdEvento(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<List<EventoAsParticipantesRequestBody>> response = new GenericResponse<>();
		try {
			response = logic.obtenerPorIdEvento(id);
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public GenericResponse<String> guardar(EventoAsParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			response = logic.guardar(body);
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public GenericResponse<String> actualizar(EventoAsParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			response = logic.actualizar(body);
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public GenericResponse<String> eliminar(Integer id) throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			response = logic.eliminar(id);
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}



}
