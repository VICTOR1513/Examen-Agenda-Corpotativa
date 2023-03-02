package com.examen.agenda.corpotativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.examen.agenda.corpotativa.model.EventosRequestBody;
import com.examen.agenda.corpotativa.model.GenericResponse;
import com.examen.agenda.corpotativa.services.EventosService;

@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "false")
@RequestMapping(value = "/eventos")
public class EventoController {

	@Autowired
	private EventosService service;

	@GetMapping(value = "/obtener", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<List<EventosRequestBody>>> ontener()
			throws HttpServerErrorException, MethodArgumentNotValidException {
		return new ResponseEntity<>(service.obtener(), HttpStatus.OK);
	}

	@GetMapping(value = "/obtener/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<EventosRequestBody>> ontenerPorId(@PathVariable int id)
			throws HttpServerErrorException, MethodArgumentNotValidException {
		return new ResponseEntity<>(service.obtenerPorId(id), HttpStatus.OK);
	}

	@PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<String>> guardar(@RequestBody EventosRequestBody body)
			throws HttpServerErrorException, MethodArgumentNotValidException {
		return new ResponseEntity<>(service.guardar(body), HttpStatus.CREATED);
	}

	@PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse<String>> actualizar(@RequestBody EventosRequestBody body)
			throws HttpServerErrorException, MethodArgumentNotValidException {
		return new ResponseEntity<>(service.actualizar(body), HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<GenericResponse<String>> eliminar(@PathVariable int id)
			throws HttpServerErrorException, MethodArgumentNotValidException {
		return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
	}

}
