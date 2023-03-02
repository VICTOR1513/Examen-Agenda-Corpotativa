package com.examen.agenda.corpotativa.logic;

import java.util.List;

import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.excepcion.ArgumentNotValidException;
import com.examen.agenda.corpotativa.model.EventosRequestBody;
import com.examen.agenda.corpotativa.model.GenericResponse;

public interface EventosLogic {
	
	public GenericResponse<List<EventosRequestBody>> obtener() throws HttpServerErrorException, ArgumentNotValidException;
	
	public GenericResponse<String> guardar(EventosRequestBody body) throws HttpServerErrorException, ArgumentNotValidException;
	
	public GenericResponse<String> actualizar(EventosRequestBody body) throws HttpServerErrorException, ArgumentNotValidException;
	
	public GenericResponse<String> eliminar(Integer id) throws HttpServerErrorException, ArgumentNotValidException;


	
}
