package com.agenda.corporativa.services;

import org.springframework.web.client.HttpServerErrorException;

import com.agenda.corporativa.excepcion.ArgumentNotValidException;
import com.agenda.corporativa.model.GenericResponse;

public interface OperacionesService {

	public GenericResponse<String> estatus() throws HttpServerErrorException, ArgumentNotValidException;
	
	public GenericResponse<?> registro(Object body) throws HttpServerErrorException, ArgumentNotValidException;

}
