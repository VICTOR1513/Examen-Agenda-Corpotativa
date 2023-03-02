package com.examen.agenda.corpotativa.utils;

import java.util.Date;

import com.examen.agenda.corpotativa.entity.Eventos;
import com.examen.agenda.corpotativa.entity.Participantes;
import com.examen.agenda.corpotativa.model.EventosRequestBody;
import com.examen.agenda.corpotativa.model.ParticipantesRequestBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectUtil {

	public static Eventos getEventos(EventosRequestBody body) {
		log.info("GET RESPUESTA : " + body.toString());
		Eventos entity = new Eventos();
		entity.setId(body.getId());
		entity.setNombre(body.getNombre());
		entity.setCupo(body.getCupo());
		entity.setFecha(new Date());
		entity.setFechaInicio(DateUtil.dateFronDateTimeString(body.getFechaInicio()));
		entity.setFechaFin(DateUtil.dateFronDateTimeString(body.getFechaFin()));
		return entity;
	}

	public static EventosRequestBody getEventosRequestBody(Eventos entity) {
		EventosRequestBody body = new EventosRequestBody();
		body.setId(entity.getId());
		body.setNombre(entity.getNombre());
		body.setCupo(entity.getCupo());
		log.info("FECHA: " + entity.getFechaInicio());
		log.info("FECHA: " + entity.getFechaFin());
		body.setFechaInicio(DateUtil.dateFronDateTimeDate(entity.getFechaInicio()));
		body.setFechaFin(DateUtil.dateFronDateTimeDate(entity.getFechaFin()));
		return body;
	}

	public static Participantes getParticipantes(ParticipantesRequestBody body) {
		log.info("GET RESPUESTA : " + body.toString());
		Participantes entity = new Participantes();
		entity.setId(body.getId());
		entity.setNombre(body.getNombre());
		entity.setApellidoPaterno(body.getApellidoPaterno());
		entity.setApellidoMaterno(body.getApellidoMaterno());
		entity.setIdRool(body.getIdRool());
		;
		return entity;
	}

	public static ParticipantesRequestBody getParticipanteRequestBody(Participantes entity) {
		ParticipantesRequestBody body = new ParticipantesRequestBody();
		body.setId(entity.getId());
		body.setNombre(entity.getNombre());
		body.setApellidoPaterno(entity.getApellidoPaterno());
		body.setApellidoMaterno(entity.getApellidoMaterno());
		body.setIdRool(entity.getIdRool());
		return body;
	}

}
