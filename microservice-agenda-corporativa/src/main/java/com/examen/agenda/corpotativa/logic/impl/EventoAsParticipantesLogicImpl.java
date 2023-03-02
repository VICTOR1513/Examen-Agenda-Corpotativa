package com.examen.agenda.corpotativa.logic.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.Repository.EventoAsParticipantesRepository;
import com.examen.agenda.corpotativa.entity.EventoAsParticipantes;
import com.examen.agenda.corpotativa.entity.Eventos;
import com.examen.agenda.corpotativa.entity.Participantes;
import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.logic.EventoAsParticipantesLogic;
import com.examen.agenda.corpotativa.model.EventoAsParticipantesRequestBody;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.utils.Constantes;
import com.examen.agenda.corpotativa.utils.ObjectUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventoAsParticipantesLogicImpl implements EventoAsParticipantesLogic {

	@Autowired
	private EventoAsParticipantesRepository dao;

	@Override
	public GenericResponse<List<EventoAsParticipantesRequestBody>> obtener()
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<List<EventoAsParticipantesRequestBody>> response = new GenericResponse<>();
		try {
			List<EventoAsParticipantes> responseBody = dao.findAll();

			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado(
					responseBody.stream().map(participante -> getEventoAsParticipantesRequestBody(participante))
							.collect(Collectors.toList()));
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
			EventoAsParticipantesRequestBody resultado = new EventoAsParticipantesRequestBody();
			Optional<EventoAsParticipantes> responseBody = dao.findById(id);
			if (responseBody.isPresent()) {
				resultado = getEventoAsParticipantesRequestBody(responseBody.get());
			}
			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado(resultado);
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
			List<EventoAsParticipantes> responseBody = dao.findEventoAsParticipantesByIdEvento(id);

			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado(
					responseBody.stream().map(participante -> getEventoAsParticipantesRequestBody(participante))
							.collect(Collectors.toList()));
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
			EventoAsParticipantes responseBody = dao.save(getEventoAsParticipantes(body));
			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado("Registro guardado exitosamente.");
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
			Optional<EventoAsParticipantes> participante = dao.findById(body.getId());
			if (participante.isPresent()) {
				EventoAsParticipantes responseBody = dao.save(getEventoAsParticipantes(participante.get(), body));
			} else {
				//throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
			}
			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado("Registro actualizado exitosamente.");
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
			dao.deleteById(id);
			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado("Registro eliminado exitosamente.");
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	private EventoAsParticipantes getEventoAsParticipantes(EventoAsParticipantesRequestBody body) {
		log.info("GET RESPUESTA : " + body.toString());
		EventoAsParticipantes entity = new EventoAsParticipantes();
		entity.setId(body.getId());
		entity.setIdParticipante(new Participantes(body.getIdParticipante().getId()));
		entity.setIdEvento(new Eventos(body.getIdEvento().getId()));
		entity.setAsistencia(body.isAsistencia());
		return entity;
	}

	private EventoAsParticipantes getEventoAsParticipantes(EventoAsParticipantes entity,
			EventoAsParticipantesRequestBody body) {
		entity.setIdParticipante(new Participantes(body.getIdParticipante().getId()));
		entity.setIdEvento(new Eventos(body.getIdEvento().getId()));
		entity.setAsistencia(body.isAsistencia());
		return entity;
	}

	private EventoAsParticipantesRequestBody getEventoAsParticipantesRequestBody(EventoAsParticipantes entity) {
		EventoAsParticipantesRequestBody body = new EventoAsParticipantesRequestBody();
		body.setId(entity.getId());
		body.setIdEvento(ObjectUtil.getEventosRequestBody(entity.getIdEvento()));
		body.setIdParticipante(ObjectUtil.getParticipanteRequestBody(entity.getIdParticipante()));
		body.setAsistencia(entity.isAsistencia());
		return body;
	}



}
