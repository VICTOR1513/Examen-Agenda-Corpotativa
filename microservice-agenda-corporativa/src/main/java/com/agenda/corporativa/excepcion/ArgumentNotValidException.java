package com.agenda.corporativa.excepcion;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ArgumentNotValidException extends MethodArgumentNotValidException {

	private static final long serialVersionUID = 1L;
	private String folio;

	public ArgumentNotValidException(BindingResult bindingResult, String folio) {
		super(null, bindingResult);
		this.folio = folio;
	}

	public String getFolio() {
		return folio;
	}

}
