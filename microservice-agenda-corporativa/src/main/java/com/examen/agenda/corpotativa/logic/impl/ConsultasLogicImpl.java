package com.examen.agenda.corpotativa.logic.impl;
//package com.baz.pagosfisicos.logic.impl;
//
//import java.nio.charset.Charset;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.jdbc.UncategorizedSQLException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.HttpServerErrorException;
//
//import com.baz.commons.exception.ArgumentNotValidException;
//import com.baz.commons.jdbc.model.DaoResponse;
//import com.baz.commons.model.GenericResponse;
//import com.baz.commons.util.RandomStringGenerator;
//import com.baz.pagosfisicos.dao.sp.OperacionesDao;
//import com.baz.pagosfisicos.logic.ConsultasLogic;
//import com.baz.pagosfisicos.model.BusquedasIndividualRequestBody;
//import com.baz.pagosfisicos.model.BusquedasResponseBody;
//import com.baz.pagosfisicos.model.BusquedasUniversoRequestBody;
//import com.baz.pagosfisicos.model.DenominacionesModel;
//import com.baz.pagosfisicos.model.DetalleSolicitudModel;
//import com.baz.pagosfisicos.model.SolicitudesModel;
//import com.baz.pagosfisicos.model.sp.SpDetalleSolicitud;
//import com.baz.pagosfisicos.model.sp.SpSolicitud;
//import com.baz.pagosfisicos.model.sp.SpSolicitudes;
//import com.baz.pagosfisicos.utils.Constantes;
//import com.baz.pagosfisicos.utils.JsonUtil;
//import com.baz.pagosfisicos.utils.ValidadorUtil;
//import com.baz.pagosfisicos.utils.enumUtil;
//import com.google.gson.Gson;
//import com.microsoft.sqlserver.jdbc.SQLServerException;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class ConsultasLogicImpl implements ConsultasLogic {
//
//
//	@Autowired
//	private OperacionesDao operacionesDao;
//
//	@Autowired
//	private RandomStringGenerator generator;
//
//	@Value("${stored.procedure}")
//	private boolean storedProcedure;
//
//	@Override
//	public GenericResponse<BusquedasResponseBody> busquedasIndividual(BusquedasIndividualRequestBody body)
//			throws HttpServerErrorException, ArgumentNotValidException {
//		log.info("REQUEST BUSQUEDA INDIVIDUAL : ");
//
//		GenericResponse<BusquedasResponseBody> response = new GenericResponse<>();
//		try {
//			DaoResponse<SpSolicitudes> SP = operacionesDao.busqueda(body);
//			response.setResultado(getResponseSP(SP.getResult()));
//			response.setMensaje(Constantes.MENSAJE_200);
//			response.setFolio(generator.folioSalida());
//		} catch (SQLServerException | UncategorizedSQLException e) {
//			log.error("Error SQL: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No se encontro ninguna solicitud.", generator.folioSalida().getBytes(),
//					Charset.defaultCharset());
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
//	public GenericResponse<BusquedasResponseBody> busquedasUniverso(BusquedasUniversoRequestBody body)
//			throws HttpServerErrorException, ArgumentNotValidException {
//		log.info("REQUEST BUSQUEDA UNIVERSO: ");
//
//		GenericResponse<BusquedasResponseBody> response = new GenericResponse<>();
//		try {
//			
//			BusquedasIndividualRequestBody bodyR = JsonUtil.jsonStringToObject(new Gson().toJson(body),
//					BusquedasIndividualRequestBody.class);	
//			bodyR.setIdTipoSolicitud(enumUtil.VALUE_ZERO.ID);
//			bodyR.setIdTipoOperacion(enumUtil.VALUE_ZERO.ID);
//	
//			DaoResponse<SpSolicitudes> SP = operacionesDao.busqueda(bodyR);
//			response.setResultado(getResponseSP(SP.getResult()));
//			response.setMensaje(Constantes.MENSAJE_200);
//			response.setFolio(generator.folioSalida());
//
//		} catch (SQLServerException | UncategorizedSQLException e) {
//			log.error("Error SQL: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "No se encontro ninguna solicitud.", generator.folioSalida().getBytes(),
//					Charset.defaultCharset());
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
//	
//	/*BUSQUEDAS*/
//
//	private BusquedasResponseBody getResponseSP(SpSolicitudes spResponse) {
//		try {
//			if (!ValidadorUtil.isEmptyCollection(spResponse.getSolicitudes())) {
//				List<SolicitudesModel> solicitudes = spResponse.getSolicitudes().stream()
//						.map(solicitud -> getSolicituides(solicitud, new ArrayList<>())).collect(Collectors.toList());
//				// SE AGRUPA POR SOLICITUD
//				Map<Integer, List<SpDetalleSolicitud>> map = spResponse.getDestallesDenominacion().stream()
//						.collect(Collectors.groupingBy(denominacion -> denominacion.getFNNUMSOLICITUD()));
//				solicitudes.stream().forEach(solicitud -> {// ITERAR SOLICITUDES
//					if (map.containsKey(solicitud.getNumeroSolicitud())) { // VAILDA NUMERO DE SOLICITUD
//						// SE AGRUPA POR CONTENEDOR
//						Map<Integer, List<SpDetalleSolicitud>> contenedorMap = map.get(solicitud.getNumeroSolicitud())
//								.stream()
//								.collect(Collectors.groupingBy(denominacion -> denominacion.getFIIDTIPOCONTENEDOR()));
//						// RECOREMOS LOS CONTENEDORES AGRUPADOS
//						contenedorMap.forEach((key, lists) -> {
//							List<DenominacionesModel> denominaciones = lists.stream()
//									.map(denominacion -> getDenominaciones(denominacion)).collect(Collectors.toList());
//							solicitud.getDetalleSolicitud().add(getDetalleSolicitud(key, denominaciones));
//						});
//					}
//				});
//				return getResultado(spResponse.getSolicitudes().get(0), solicitudes);
//			}
//			return new BusquedasResponseBody(); // REVISAR RETURN 400
//		} catch (Exception e) {
//			log.error("Error: " + ExceptionUtils.getStackTrace(e));
//			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, Constantes.MENSAJE_500,
//					generator.folioSalida().getBytes(), Charset.defaultCharset());
//		}
//	}
//
//	private BusquedasResponseBody getResultado(SpSolicitud spSolicitud, List<SolicitudesModel> solicitudes) {
//		BusquedasResponseBody entity = new BusquedasResponseBody();
//		entity.setIdTipoDispositivo(spSolicitud.getFIIDTIPODISPOSITIVO());
//		entity.setDescripcionDispositivo(
//				spSolicitud.getFCNOMDISPOSITIVO());/***** PENDIENTE CATALOGO DISPOSITIVOS *****/
//		entity.setIdDispositivo(spSolicitud.getFCIDDISPOSITIVO());
//		entity.setNumeroEmpleadoDispositivo(spSolicitud.getFCEMPLEADODISP().toString());
//		entity.setSolicitudes(ValidadorUtil.isEmptyObject(solicitudes) ? new ArrayList<>() : solicitudes);
//		return entity;
//	}
//
//	private SolicitudesModel getSolicituides(SpSolicitud spSolicitud, List<DetalleSolicitudModel> DetalleSolicitud) {
//		SolicitudesModel entity = new SolicitudesModel();
//		entity.setIdTipoSolicitud(spSolicitud.getFIIDTIPOSOLICITUD());
//		entity.setDescripcionSolicitud(spSolicitud.getFCTIPOSOLICITUD());
//		entity.setIdTipoOperacion(spSolicitud.getFIIDSOLICITUDOPERA());
//		entity.setDescripcionTipoOperacion(spSolicitud.getFCSOLICITUDOPERA());
//		entity.setNumeroSolicitud(spSolicitud.getFNNUMSOLICITUD());
//		entity.setIdDivisa(spSolicitud.getFIIDDIVISA());
//		entity.setDescripcionDivisa(spSolicitud.getFCABREVIATURA());
//		entity.setIdEstatus(spSolicitud.getFIIDESTATUS());
//		entity.setDescripcionEstatus(spSolicitud.getFCNOMESTATUS());
//		entity.setSaldoSolicitado(spSolicitud.getFNSALDOSOLICITADO());
//		entity.setFechaSolicitud(spSolicitud.getFDFECHASOLICITUD());
//		entity.setFechaAutorizada(spSolicitud.getFDFECHAAUTORIZA());
//		entity.setNumeroEmpleadoAutorizante(spSolicitud.getFCEMPLEADOAUTORIZA().toString());
//		entity.setNumeroEmpleado(spSolicitud.getFCEMPLEADO().toString());
//		entity.setIdOperacionOrigen(spSolicitud.getFIIDOPERACIONORIGEN());
//		entity.setDescripcionOrigen(spSolicitud.getFCOPERACIONORIGEN());
//		entity.setDetalleSolicitud(DetalleSolicitud);
//		return entity;
//	}
//
//	private DetalleSolicitudModel getDetalleSolicitud(Integer idContenedor, List<DenominacionesModel> denominaciones) {
//		DetalleSolicitudModel detalle = new DetalleSolicitudModel();
//		detalle.setIdTipoContenedor(idContenedor);
//		detalle.setDenominaciones(ValidadorUtil.isEmptyObject(denominaciones) ? new ArrayList<>() : denominaciones);
//		return detalle;
//	}
//
//	private DenominacionesModel getDenominaciones(SpDetalleSolicitud entity) {
//		DenominacionesModel denominacion = new DenominacionesModel();
//		denominacion.setId(entity.getFIIDDENOM());
//		denominacion.setIdTipoDenominacion(entity.getFNTIPODENOM());
//		denominacion.setNumeroPiezas(entity.getFNPIEZAS());
//		denominacion.setTotal(entity.getFNPIEZAS() * entity.getFIIDDENOM());
//		return denominacion;
//	}
//
//}
