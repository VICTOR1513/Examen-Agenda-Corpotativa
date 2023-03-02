package com.agenda.corporativa.logic;

import org.springframework.web.client.HttpServerErrorException;

import com.agenda.corporativa.excepcion.ArgumentNotValidException;
import com.agenda.corporativa.model.GenericResponse;


public interface OperacionesLogic {

	public GenericResponse<?> registro(Object body) throws HttpServerErrorException, ArgumentNotValidException;

}
