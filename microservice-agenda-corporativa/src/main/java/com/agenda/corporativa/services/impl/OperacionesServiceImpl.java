package com.agenda.corporativa.services.impl;

import java.nio.charset.Charset;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.agenda.corporativa.excepcion.ArgumentNotValidException;
import com.agenda.corporativa.logic.OperacionesLogic;
import com.agenda.corporativa.model.GenericResponse;
import com.agenda.corporativa.services.OperacionesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperacionesServiceImpl implements OperacionesService {

	@Autowired
	private OperacionesLogic logic;

//	@Autowired
//	private RandomStringGenerator generator;

	@Override
	public GenericResponse<String> estatus() throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<String> response = new GenericResponse<>();
		try {
			response.setMensaje("OK");
//			response.setFolio(generator.folioSalida());
		} catch (Exception e) {
			log.error("Error al consultar saldos: " + e);
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public GenericResponse<?> registro(Object body)	 throws HttpServerErrorException, ArgumentNotValidException {
		GenericResponse<?> response = new GenericResponse<>();
		try {
//			response = logic.registro(body);
		} catch (HttpServerErrorException e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(e.getStatusCode());
		} catch (Exception e) {
			log.error("Error: " + ExceptionUtils.getStackTrace(e));
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

//	@Override
//	public GenericResponse<?> confirmacion(ConfirmacionRequestBody body)
//			throws HttpServerErrorException, ArgumentNotValidException {
//		GenericResponse<?> response = new GenericResponse<>();
//		try {
//			response = logic.confirmacion(body);
//		} catch (HttpServerErrorException e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(e.getStatusCode(), e.getStatusText(), generator.folioSalida().getBytes(),
//					Charset.defaultCharset());
//		} catch (Exception e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, ConstantesError.ERROR_500,
//					generator.folioSalida().getBytes(), Charset.defaultCharset());
//		}
//		return response;
//	}
//
//	@Override
//	public GenericResponse<?> confirmacionIndividual(ConfirmacionIndividualRequestBody body)
//			throws HttpServerErrorException, ArgumentNotValidException {
//		GenericResponse<?> response = new GenericResponse<>();
//		try {
//			response = logic.confirmacionIndividual(body);
//		} catch (HttpServerErrorException e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(e.getStatusCode(), e.getStatusText(), generator.folioSalida().getBytes(),
//					Charset.defaultCharset());
//		} catch (Exception e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, ConstantesError.ERROR_500,
//					generator.folioSalida().getBytes(), Charset.defaultCharset());
//		}
//		return response;
//	}

}
