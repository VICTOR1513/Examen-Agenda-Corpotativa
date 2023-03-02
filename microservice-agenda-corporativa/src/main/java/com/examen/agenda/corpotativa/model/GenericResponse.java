package com.examen.agenda.corpotativa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class GenericResponse<T> {

	private String codigo;

	private String mensaje;

	private String folio;

	private T resultado;

	private String info;

	private List<?> detalles;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public T getResultado() {
		return resultado;
	}

	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<?> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<?> detalles) {
		this.detalles = detalles;
	}

	public GenericResponse() {
		super();
	}

	public GenericResponse(String codigo, String mensaje, String folio, T resultado, String info, List<?> detalles) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.folio = folio;
		this.resultado = resultado;
		this.info = info;
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "GenericResponse [codigo=" + codigo + ", mensaje=" + mensaje + ", folio=" + folio + ", resultado="
				+ resultado + ", info=" + info + ", detalles=" + detalles + "]";
	}

}
