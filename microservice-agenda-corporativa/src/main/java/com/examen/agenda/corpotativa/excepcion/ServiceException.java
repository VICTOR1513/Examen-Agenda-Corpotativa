package com.examen.agenda.corpotativa.excepcion;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -8949090235939998120L;
	
	private List<String> detalles = new ArrayList<>();
	
	private String logServidor;
	
	private boolean imprimeStackTrace;
	
	private String errorCode;
	
	public ServiceException(List<String> detalles, String logServidor, String errorCode) {
		this.detalles = detalles;
		this.logServidor = logServidor;
		this.errorCode = errorCode;
	}

}
