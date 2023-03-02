package com.examen.agenda.corpotativa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.services.OperacionesService;
import com.examen.agenda.corpotativa.utils.Constantes;

@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "false")
public class OperacionesController {

	@Autowired
	private OperacionesService service;

	@GetMapping(value = Constantes.API_CHECK_SERVER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<String>> checkStatus()
			throws HttpServerErrorException, MethodArgumentNotValidException {
		return new ResponseEntity<>(service.estatus(), HttpStatus.OK);
	}

	@PostMapping(value = Constantes.API_REGISTRO, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<?>> registro(@RequestBody Object body)
			throws HttpServerErrorException, MethodArgumentNotValidException {
//		valida.performValidation(body, "body");
		return new ResponseEntity<>(service.registro(body), HttpStatus.OK);
	}

}
