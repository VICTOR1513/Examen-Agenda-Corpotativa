package com.examen.agenda.corpotativa.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.services.OperacionesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperacionesServiceImpl implements OperacionesService {


	@Override
	public GenericResponse<String> estatus() throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			response.setMensaje("OK");
//			response.setFolio(generator.folioSalida());
		} catch (Exception e) {
			log.error("Error al consultar saldos: " + e);
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
