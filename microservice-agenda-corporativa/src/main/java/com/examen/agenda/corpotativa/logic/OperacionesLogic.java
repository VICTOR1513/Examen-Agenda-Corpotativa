package com.examen.agenda.corpotativa.logic;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.model.GenericResponse;
import org.springframework.web.client.HttpServerErrorException;


public interface OperacionesLogic {

	public GenericResponse<?> registro(Object body) throws HttpServerErrorException, ArgumentNotValidException;

}
