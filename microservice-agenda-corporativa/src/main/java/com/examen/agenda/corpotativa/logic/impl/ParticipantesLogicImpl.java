package com.examen.agenda.corpotativa.logic.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.Repository.ParticipantesRepository;
import com.examen.agenda.corpotativa.entity.Participantes;
import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.logic.ParticipantesLogic;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.model.ParticipantesRequestBody;
import com.examen.agenda.corpotativa.utils.Constantes;
import com.examen.agenda.corpotativa.utils.ObjectUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ParticipantesLogicImpl implements ParticipantesLogic {

	@Autowired
	private ParticipantesRepository dao;

	@Override
	public GenericResponse<List<ParticipantesRequestBody>> obtener()
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<List<ParticipantesRequestBody>> response = new GenericResponse<>();
		try {
			List<Participantes> responseBody = dao.findAll();

			response.setMensaje(Constantes.MENSAJE_200);
			response.setResultado(responseBody.stream().map(participante -> ObjectUtil.getParticipanteRequestBody(participante))
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
	public GenericResponse<ParticipantesRequestBody> obtenerPorId(Integer id)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<ParticipantesRequestBody> response = new GenericResponse<>();
		try {
			ParticipantesRequestBody resultado = new ParticipantesRequestBody();
			Optional<Participantes> responseBody = dao.findById(id);
			if (responseBody.isPresent()) {
				resultado = ObjectUtil.getParticipanteRequestBody(responseBody.get());
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
	public GenericResponse<String> guardar(ParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			Participantes responseBody = dao.save(ObjectUtil.getParticipantes(body));
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
	public GenericResponse<String> actualizar(ParticipantesRequestBody body)
			throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			Optional<Participantes> participante = dao.findById(body.getId());
			if (participante.isPresent()) {
				Participantes responseBody = dao.save(getParticipantes(participante.get(), body));
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

//	private Participantes getParticipantes(ParticipantesRequestBody body) {
//		log.info("GET RESPUESTA : " + body.toString());
//		Participantes entity = new Participantes();
//		entity.setId(body.getId());
//		entity.setNombre(body.getNombre());
//		entity.setApellidoPaterno(body.getApellidoPaterno());
//		entity.setApellidoMaterno(body.getApellidoMaterno());
//		entity.setIdRool(body.getIdRool());
//		;
//		return entity;
//	}

	private Participantes getParticipantes(Participantes entity, ParticipantesRequestBody body) {
		entity.setNombre(body.getNombre());
		entity.setApellidoPaterno(body.getApellidoPaterno());
		entity.setApellidoMaterno(body.getApellidoMaterno());
		entity.setIdRool(body.getIdRool());
		return entity;
	}

//	private ParticipantesRequestBody getParticipanteRequestBody(Participantes entity) {
//		ParticipantesRequestBody body = new ParticipantesRequestBody();
//		body.setId(entity.getId());
//		body.setNombre(entity.getNombre());
//		body.setApellidoPaterno(entity.getApellidoPaterno());
//		body.setApellidoMaterno(entity.getApellidoMaterno());
//		body.setIdRool(entity.getIdRool());
//		return body;
//	}

}
