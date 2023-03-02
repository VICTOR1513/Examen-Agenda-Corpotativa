package com.examen.agenda.corpotativa.logic.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.Repository.EventosRepository;
import com.examen.agenda.corpotativa.entity.Eventos;
import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.logic.EventosLogic;
import com.examen.agenda.corpotativa.model.EventosRequestBody;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.utils.Constantes;
import com.examen.agenda.corpotativa.utils.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventosLogicImpl implements EventosLogic {

	@Autowired
	private EventosRepository dao;

	@Override
	public GenericResponse<List<EventosRequestBody>> obtener()
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<List<EventosRequestBody>> response = new GenericResponse<>();
		try {
			List<Eventos> responseBody = dao.findAll();

			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado(
					responseBody.stream().map(evento -> getEventosRequestBody(evento)).collect(Collectors.toList()));
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
	public GenericResponse<EventosRequestBody> obtenerPorId(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<EventosRequestBody> response = new GenericResponse<>();
		try {
			EventosRequestBody resultado = new EventosRequestBody();
			Optional<Eventos> responseBody = dao.findById(id);
			if (responseBody.isPresent()) {
				resultado = getEventosRequestBody(responseBody.get());
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
	public GenericResponse<String> guardar(EventosRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			Eventos responseBody = dao.save(getEventos(body));
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
	public GenericResponse<String> actualizar(EventosRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			Optional<Eventos> evento = dao.findById(body.getId());
			if (evento.isPresent()) {
				Eventos responseBody = dao.save(getEventos(evento.get(), body));
			} else {
				throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
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

	private Eventos getEventos(EventosRequestBody body) {
		log.info("GET RESPUESTA : "+body.toString());
		Eventos entity = new Eventos();
		entity.setId(body.getId());
		entity.setNombre(body.getNombre());
		entity.setCupo(body.getCupo());
		entity.setFecha(new Date());
		entity.setFechaInicio(DateUtil.dateFronDateTimeString(body.getFechaInicio()));
		entity.setFechaFin(DateUtil.dateFronDateTimeString(body.getFechaFin()));
		return entity;
	}

	private Eventos getEventos(Eventos entity, EventosRequestBody body) {
//		entity.setId(body.getId());
		entity.setNombre(body.getNombre());
		entity.setCupo(body.getCupo());
		entity.setFechaModifico(new Date());
		entity.setFechaInicio(DateUtil.dateFronDateTimeString(body.getFechaInicio()));
		entity.setFechaFin(DateUtil.dateFronDateTimeString(body.getFechaFin()));
		return entity;
	}

	private EventosRequestBody getEventosRequestBody(Eventos entity) {
		EventosRequestBody body = new EventosRequestBody();
		body.setId(entity.getId());
		body.setNombre(entity.getNombre());
		body.setCupo(entity.getCupo());
		log.info("FECHA: "+entity.getFechaInicio());
		log.info("FECHA: "+entity.getFechaFin());
		body.setFechaInicio(DateUtil.dateFronDateTimeDate(entity.getFechaInicio()));
		body.setFechaFin(DateUtil.dateFronDateTimeDate(entity.getFechaFin()));
		return body;
	}

}
