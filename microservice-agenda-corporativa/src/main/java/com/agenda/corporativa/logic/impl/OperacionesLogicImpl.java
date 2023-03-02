package com.agenda.corporativa.logic.impl;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import com.agenda.corporativa.excepcion.ArgumentNotValidException;
import com.agenda.corporativa.logic.OperacionesLogic;
import com.agenda.corporativa.model.GenericResponse;
import com.agenda.corporativa.utils.Constantes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OperacionesLogicImpl implements OperacionesLogic {

//	@Autowired
//	private RandomStringGenerator generator;

//	@Autowired
//	private OperacionesDao operacionesDao;

	@Override
	public GenericResponse<?> registro(Object body)
			throws HttpServerErrorException, ArgumentNotValidException {
//		log.info("REQUEST REGISTRO: " + new Gson().toJson(body));

		GenericResponse<Map<String, Object>> response = new GenericResponse<>();
		try {
			Map<String, Object> responseBody = new HashMap<String, Object>();
//			DaoResponse<?> SP = operacionesDao.registro(body);

//			if(SP.getCode() == 1002) {
//				throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Parámetros no válidos, por favor valide su información.", generator.folioSalida().getBytes(),
//						Charset.defaultCharset());
//			}
			response.setMensaje(Constantes.MENSAJE_200);
//			response.setFolio(generator.folioSalida());
//			responseBody.put("folio", SP.getCode());
			responseBody.put("mensaje", " Solicitud guardada correctamente.");
			response.setResultado(responseBody);
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
//		log.info("REQUEST CONFIRMACION..............: ");
//
//		GenericResponse<Map<String, Object>> response = new GenericResponse<>();
//		try {
//			Map<String, Object> responseBody = new HashMap<String, Object>();
//
//			ConfirmacionIndividualRequestBody bodyR = JsonUtil.jsonStringToObject(new Gson().toJson(body),
//					ConfirmacionIndividualRequestBody.class);
//			bodyR.setIdTipoSolicitud(enumUtil.TIPO_SOLICITUD_MIXTO.ID);
//
//			DaoResponse<?> SP = operacionesDao.confirmacion(bodyR);
//			
//			if(SP.getCode() == 1002) {
//				throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe la solicitud por confirmar.", generator.folioSalida().getBytes(),
//						Charset.defaultCharset());
//			}
//			response.setMensaje(Constantes.MENSAJE_200);
//			response.setFolio(generator.folioSalida());
//			responseBody.put("folio", SP.getCode());
//			responseBody.put("mensaje", "Solicitud confirmada correctamente.");
//			response.setResultado(responseBody);
//		} catch (HttpServerErrorException e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(e.getStatusCode(), e.getStatusText(), generator.folioSalida().getBytes(),
//					Charset.defaultCharset());
//		} catch (Exception e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, Constantes.MENSAJE_500,
//					generator.folioSalida().getBytes(), Charset.defaultCharset());
//		}
//		return response;
//	}
//
//	@Override
//	public GenericResponse<?> confirmacionIndividual(ConfirmacionIndividualRequestBody body)
//			throws HttpServerErrorException, ArgumentNotValidException {
//		log.info("REQUEST CONFIRMACION INDIVIDUAL............: ");
//
//		GenericResponse<Map<String, Object>> response = new GenericResponse<>();
//		try {
//			Map<String, Object> responseBody = new HashMap<String, Object>();
//			DaoResponse<?> SP = operacionesDao.confirmacion(body);
//			
//			if(SP.getCode() == 1002) {
//				throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No existe la solicitud por confirmar.", generator.folioSalida().getBytes(),
//						Charset.defaultCharset());
//			}
//			response.setMensaje(Constantes.MENSAJE_200);
//			response.setFolio(generator.folioSalida());
//			responseBody.put("folio", SP.getCode());
//			responseBody.put("mensaje",  "Solicitud confirmada correctamente.");
//			response.setResultado(responseBody);
//		} catch (HttpServerErrorException e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(e.getStatusCode(), e.getStatusText(), generator.folioSalida().getBytes(),
//					Charset.defaultCharset());
//		} catch (Exception e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, Constantes.MENSAJE_500,
//					generator.folioSalida().getBytes(), Charset.defaultCharset());
//		}
//		return response;
//	}

}
