package com.agenda.corporativa.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component

public class Respuesta implements Serializable {

	private Integer codigo;
	private String mensaje;

	private static final long serialVersionUID = 1L;

	public Respuesta() {
	}

	public Respuesta(Integer codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
