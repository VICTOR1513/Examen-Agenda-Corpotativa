package com.examen.agenda.corpotativa.excepcion;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 322249887256613160L;

	private List<String> detalles = new ArrayList<>();
	
	private String logServidor;
	
	private boolean imprimeStackTrace;
	
	private String errorCode;
	
	public UnauthorizedException(List<String> detalles, String logServidor, String errorCode) {
		this.detalles = detalles;
		this.logServidor = logServidor;
		this.errorCode = errorCode;
	}
	
	public UnauthorizedException(List<String> detalles, String logServidor, Throwable cause, String errorCode) {
		super(cause);
		this.detalles = detalles;
		this.logServidor = logServidor;
		imprimeStackTrace = true;
		this.errorCode = errorCode;
	}

}
