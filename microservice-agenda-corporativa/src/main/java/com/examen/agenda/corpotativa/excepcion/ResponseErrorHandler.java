package com.examen.agenda.corpotativa.excepcion;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

/**
<b>ResponseErrorHandler.java</b> 
@version: Superapp 1.0
@descripcion: clase para sobreescribir los errores en rest teamplate
@author: ibrahim, Desarrollador
@ultimaModificacion: 27 jul. 2021 13:20:03
*/
public class ResponseErrorHandler extends DefaultResponseErrorHandler{
	
	@Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    // your error handling here
	  }

}