package com.examen.agenda.corpotativa.exceptionhandler;
//package com.baz.pagosfisicos.exceptionhandler;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////import javax.servlet.http.HttpServletRequest;
////import javax.validation.ConstraintViolationException;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingRequestValueException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.client.HttpServerErrorException;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
////import com.baz.commons.exception.ErrorUtil;
////import com.baz.commons.model.GenericResponse;
////import com.baz.commons.util.ConstantesError;
////import com.baz.commons.util.RandomStringGenerator;
////import com.baz.pagosfisicos.excepcion.LogicException;
////import com.baz.pagosfisicos.excepcion.ParamsException;
//import com.baz.pagosfisicos.excepcion.ServiceException;
//import com.baz.pagosfisicos.excepcion.UnauthorizedException;
//import com.baz.pagosfisicos.excepcion.enums.ErrorCode400;
//import com.baz.pagosfisicos.excepcion.enums.ErrorCode500;
//import com.baz.pagosfisicos.model.GenericResponse;
//import com.baz.pagosfisicos.utils.RandomStringGenerator;
//import com.baz.pagosfisicos.utils.RespuestasHttp;
//import com.fasterxml.jackson.databind.JsonMappingException.Reference;
//import com.fasterxml.jackson.databind.exc.MismatchedInputException;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.ConstraintViolationException;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@ControllerAdvice
//public class GlobalExceptionHandlerController /*extends ResponseEntityExceptionHandler*/ {
//	
//	@Autowired
//	private RandomStringGenerator generator;
//
//	private  String NB_APLICACION_TMP = "Pagos-Fisicos-Caja-Central";	
//	private final String MENSAJE_400 = "Argumento no válido.";
//	private final String MENSAJE_401 = "Recurso no autorizado.";
//	
//    //@Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
//    		HttpHeaders headers, HttpStatus status, WebRequest request) {
//    	GenericResponse<String> response1 = new GenericResponse<>();
//    	response1.setMensaje(MENSAJE_400);
//		response1.setCodigo(RespuestasHttp.getCodigo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));		
//    	response1.setInfo(RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
//		ArrayList<String> mensaje = new ArrayList<>();
//		mensaje.add("");
//		response1.setDetalles(mensaje);
//		response1.setFolio(generator.folioSalida());
//		
//		imprimeLog(response1, ex);
//    	return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
//    }
//    
//    //@Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//    		HttpHeaders headers, HttpStatus status, WebRequest request) {
//    	GenericResponse<String> response1 = new GenericResponse<>();
//    	BindingResult bindingResult=ex;	
//		response1.setCodigo(RespuestasHttp.getCodigo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));		
//    	response1.setInfo(RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
////		response1.setDetalles("");
//		response1.setFolio(generator.folioSalida());
//		
//		imprimeLog(response1);
//    	return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
//    }
//    
////    @ExceptionHandler(ParamsException.class)
////    public ResponseEntity<Object> paramsException(ParamsException ex) {
////    	GenericResponse<String> response1 = new GenericResponse<>();
////    	Map<String, ParamsException> maps = new HashMap<>();
////		maps.put("Error" , ex);
////		String errorCode="";
////		List<String> mensajeDetalles= new ArrayList<>();
////		for (Map.Entry<String, ParamsException> resul : maps.entrySet()) {
////			 errorCode=resul.getValue().getErrorCode();
////			 mensajeDetalles.addAll(resul.getValue().getDetalles());
////			
////		}
////    	response1.setMensaje(MENSAJE_400);
////		response1.setCodigo(RespuestasHttp.getCodigo400(NB_APLICACION_TMP, errorCode));		
////    	response1.setInfo(RespuestasHttp.getInfo400(NB_APLICACION_TMP, errorCode));
////		response1.setDetalles(mensajeDetalles);
////		response1.setFolio(generator.folioSalida());
////		imprimeLog(response1, ex.getLogServidor(), ex.isImprimeStackTrace(), ex);
////    	return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
////    }
//    
//    @ExceptionHandler(MissingRequestValueException.class)
//    protected ResponseEntity<Object> missingRequestValueException(MissingRequestValueException ex){
//    	GenericResponse<String> response1 = new GenericResponse<>();
//    	Map<String, MissingRequestValueException> maps = new HashMap<>();
//		maps.put("Error" , ex);
//		List<String> mensajeDetalles= new ArrayList<>();
//		
//		for (Map.Entry<String, MissingRequestValueException> resul : maps.entrySet()) {
//			 mensajeDetalles.add(resul.getValue().getMessage());
//		}
//    	response1.setMensaje(MENSAJE_400);
//		response1.setCodigo(RespuestasHttp.getCodigo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));		
//    	response1.setInfo(RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
//		response1.setDetalles(mensajeDetalles);
//		response1.setFolio(generator.folioSalida());
//		
//		imprimeLog(response1, ex);
//    	return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
//    }
//    
//    @ExceptionHandler(ConstraintViolationException.class)
//   	public ResponseEntity<Object> handleResourceNotFoundException(ConstraintViolationException ex) {
//       	GenericResponse<String> response1 = new GenericResponse<>();
//       	response1.setMensaje(MENSAJE_400);
//		response1.setCodigo(RespuestasHttp.getCodigo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));		
//    	response1.setInfo(RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
//   	 Map<String, ConstraintViolationException> maps = new HashMap<>();
//		maps.put("Error" , ex);
//		List<String> mensajeDetalles= new ArrayList<>();
//		for (Map.Entry<String, ConstraintViolationException> resul : maps.entrySet()) {
//			 mensajeDetalles.add(resul.getValue().getMessage());
//			
//		}
//   	    
//   		    
//   		response1.setDetalles(mensajeDetalles);
//   		response1.setFolio(generator.folioSalida());
//   		imprimeLog(response1);
//       	return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);
//   	}
//    
//    public ResponseEntity<Object> mismatchedInputException(MismatchedInputException ex) { 	
//    	String campo = ""; 
//    			
//    	for(Reference reference : ex.getPath()) {
//    		if(reference.getFieldName() != null) {
//    			campo += reference.getFieldName() + ".";
//    		}
//    	}    	    	
//    	       	
//		String error = "El campo " + StringUtils.chop(campo)
//				+ " no cumple con el tipo de dato requerido, favor de verificar el contrato";
//    	
//    	GenericResponse<String> response1 = new GenericResponse<>();
//    	response1.setMensaje(MENSAJE_400);
//		response1.setCodigo(RespuestasHttp.getCodigo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));		
//    	response1.setInfo(RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
//		response1.setDetalles(Arrays.asList(error));
//		response1.setFolio(generator.folioSalida());
//		
//		imprimeLog(response1);
//    	return new ResponseEntity<>(response1, HttpStatus.BAD_REQUEST);    	
//    }
//    
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseEntity<Object> unauthorizedException(UnauthorizedException ex) {
//    	GenericResponse<String> response = new GenericResponse<>();
//    	Map<String, UnauthorizedException> maps = new HashMap<>();
//		maps.put("Error" , ex);
//		List<String> mensajeDetalles= new ArrayList<>();
//		String errorCode="";
//		for (Map.Entry<String, UnauthorizedException> resul : maps.entrySet()) {
//			 errorCode=resul.getValue().getErrorCode();
//			 mensajeDetalles.addAll(resul.getValue().getDetalles());
//		}
//		String codigo=RespuestasHttp.getCodigo401(NB_APLICACION_TMP,errorCode);
//    	response.setMensaje(MENSAJE_401);
//		response.setCodigo(codigo);
//    	response.setInfo(RespuestasHttp.getInfo401(NB_APLICACION_TMP,errorCode));
//    	response.setFolio(generator.folioSalida());
//		response.setDetalles(mensajeDetalles);
//		
//		imprimeLog(response, ex.getLogServidor(), ex.isImprimeStackTrace(), ex);	
//    	return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//    }
//    
//    //@Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
//    		HttpStatus status, WebRequest request) {
//    	
//    	if(ex.getCause() instanceof MismatchedInputException) {
//			return mismatchedInputException((MismatchedInputException) ex.getCause());
//		}
//    	
//    	GenericResponse<String> response1 = new GenericResponse<>();
//    	response1.setMensaje("500");
//		response1.setCodigo(RespuestasHttp.getCodigo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo()));
//		response1.setInfo(RespuestasHttp.getInfo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo()));
//		ArrayList<String> mensaje = new ArrayList<>();
//		mensaje.add("");
//		response1.setDetalles(mensaje);
//		response1.setFolio(generator.folioSalida());
//		
//		imprimeLog(response1, ex);
//    	return new ResponseEntity<>(response1, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    
//    @ExceptionHandler(ServiceException.class)
//    public ResponseEntity<Object> serviceException(ServiceException ex){
//    	GenericResponse<String> response = new GenericResponse<>();
//    	Map<String, ServiceException> maps = new HashMap<>();
//		maps.put("Error" , ex);
//		List<String> mensajeDetalles= new ArrayList<>();
//		String errorCode="";
//		for (Map.Entry<String, ServiceException> resul : maps.entrySet()) {
//			 errorCode=resul.getValue().getErrorCode();
//			 mensajeDetalles.addAll(resul.getValue().getDetalles());
//		}
//		response.setCodigo(RespuestasHttp.getCodigo500(NB_APLICACION_TMP, errorCode));
//		response.setInfo(RespuestasHttp.getInfo500(NB_APLICACION_TMP,errorCode));
//    	response.setMensaje("500");
//    	response.setFolio(generator.folioSalida());
//		response.setDetalles(mensajeDetalles);
//				
//		imprimeLog(response, ex.getLogServidor(), ex.isImprimeStackTrace(), ex);			
//    	return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    
////    @ExceptionHandler(LogicException.class)
////    public ResponseEntity<Object> logicException(LogicException ex){
////    	GenericResponse<String> response = new GenericResponse<>();
////    	Map<String, LogicException> maps = new HashMap<>();
////		maps.put("Error" , ex);
////		String errorCode="";
////		List<String> mensajeDetalles= new ArrayList<>();
////		for (Map.Entry<String, LogicException> resul : maps.entrySet()) {
////			 errorCode=resul.getValue().getErrorCode();
////			 mensajeDetalles.addAll(resul.getValue().getDetalles());
////			
////		}
////		response.setCodigo(RespuestasHttp.getCodigo500(NB_APLICACION_TMP, errorCode));
////		response.setInfo(RespuestasHttp.getInfo500(NB_APLICACION_TMP, errorCode));
////    	response.setMensaje(ConstantesError.ERROR_500);
////    	response.setFolio(generator.folioSalida());
////		response.setDetalles(mensajeDetalles);    					
////			
////		imprimeLog(response, ex.getLogServidor(), ex.isImprimeStackTrace(), ex);		
////    	return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
////    }
//    
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleException(Exception ex){ 
//    	GenericResponse<String> response = new GenericResponse<>();
//		response.setMensaje("ERROR 500");
//		response.setCodigo(RespuestasHttp.getCodigo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo()));
//		response.setInfo(RespuestasHttp.getInfo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo()));
//		response.setFolio(generator.folioSalida());
//		response.setDetalles(Arrays.asList("500"));
//		
//    	imprimeLog(response, ex);
//		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    
//    /*@ExceptionHandler(HttpServerErrorException.class)
//    private ResponseEntity<Object> exceptionHandler(HttpServerErrorException ex, HttpServletRequest request) {
//    	GenericResponse<String> response = new GenericResponse<>();
//		response.setMensaje(ConstantesError.ERROR_500);
//		response.setCodigo(RespuestasHttp.getCodigo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo()));
//		response.setInfo(RespuestasHttp.getInfo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo()));
//		response.setFolio(generator.folioSalida());
//		ArrayList<String> mensaje = new ArrayList<>();
//		mensaje.add(ConstantesError.ERROR_500);
//		response.setDetalles(mensaje);
//		
//		imprimeLog(response, ex);
//		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }*/
//    
//    @ExceptionHandler(HttpServerErrorException.class)
//	private ResponseEntity<Object> exceptionHandler(HttpServerErrorException ex, HttpServletRequest request) {
//		// System.out.println("8 HttpServerErrorException:
//		// "+ParseUtils.getStackTrace(ex));
//		Map<String, HttpServerErrorException> maps = new HashMap<String, HttpServerErrorException>();
//		maps.put("error", ex);
//		String status = new String();
//		String statusText = new String();
//		for (Map.Entry<String, HttpServerErrorException> resul : maps.entrySet()) {
//			status = resul.getValue().getStatusCode().toString();
//			statusText = resul.getValue().getStatusText();
//
//		}
//		log.info("ERROR8: HttpServerErrorException Captacion");
//		GenericResponse<String> response = new GenericResponse<>();
//		response.setMensaje(
//				status.equals(HttpStatus.INTERNAL_SERVER_ERROR.toString()) ?"500"
//						: MENSAJE_400);
//		
//		response.setCodigo(status.equals(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//				? RespuestasHttp.getCodigo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo())
//				: RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
//		
//		response.setInfo(status.equals(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//				? RespuestasHttp.getCodigo500(NB_APLICACION_TMP, ErrorCode500.EXCEPCION_NO_CONTROLADA.codigo())
//				: RespuestasHttp.getInfo400(NB_APLICACION_TMP, ErrorCode400.PARAMETRO_INVALIDO.codigo()));
//		
//		response.setFolio(generator.folioSalida());
//		ArrayList<String> mensaje = new ArrayList<>();
//		mensaje.add(statusText);
//		response.setDetalles(mensaje);
//		imprimeLog(response, ex);
//		return new ResponseEntity<>(response, ex.getStatusCode());
//	}
//    
//    
//    
//    
//    public void imprimeLog(GenericResponse<String> response, String logServidor, boolean imprimeStackTrace, Throwable ex)  {
//    	log.error(response.toString());
//    	
//    	if(StringUtils.isNotBlank(logServidor))
//    		log.error("Folio de error : " + response.getFolio() + " " + logServidor); 
//				
//		if(imprimeStackTrace) 
//			log.error("Folio de error:  " + response.getFolio() + " " + ExceptionUtils.getStackTrace(ex));
//    }
//    
//    public void imprimeLog(GenericResponse<String> response, Throwable ex) {    	    	
//    	log.error(response.toString());
//    	log.error("Folio de error: " + response.getFolio() + " " + ExceptionUtils.getStackTrace(ex));
//    }
//    
//    public void imprimeLog(GenericResponse<String> response) {
//    	log.error(response.toString());
//    }
//
//}