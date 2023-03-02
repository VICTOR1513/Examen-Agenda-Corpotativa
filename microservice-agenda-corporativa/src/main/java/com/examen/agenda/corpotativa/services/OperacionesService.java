package com.examen.agenda.corpotativa.services;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.model.GenericResponse;

public interface OperacionesService {

	public GenericResponse<String> estatus() throws HttpServerErrorException, ArgumentNotValidException;

}
