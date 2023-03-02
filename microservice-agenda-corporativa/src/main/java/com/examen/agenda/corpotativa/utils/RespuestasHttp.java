package com.examen.agenda.corpotativa.utils;

public class RespuestasHttp {


	public static String getCodigo400(String nombreProyecto, String codigoError) {
		return "400." + nombreProyecto + ".400" + codigoError;
	}
	
	public static String getInfo400(String nombreProyecto, String codigoError) {
		return "https://baz-developer.bancoazteca.com.mx/info#400." + nombreProyecto + ".400"  + codigoError;
	}
	
	public static String getCodigo401(String nombreProyecto, String codigoError) {
		return "401." + nombreProyecto + ".401" + codigoError;
	}
	
	public static String getInfo401(String nombreProyecto, String codigoError) {
		return "https://baz-developer.bancoazteca.com.mx/info#401." + nombreProyecto + ".401"  + codigoError;
	}
	
	public static String getCodigo404(String nombreProyecto, String codigoError) {
		return "404." + nombreProyecto + ".404" + codigoError;
	}
	
	public static String getInfo404(String nombreProyecto, String codigoError) {
		return "https://baz-developer.bancoazteca.com.mx/info#404." + nombreProyecto + ".404"  + codigoError;
	}
	
	public static String getCodigo500(String nombreProyecto, String codigoError) {
		return "500." + nombreProyecto + ".500" + codigoError;
	}
	
	public static String getInfo500(String nombreProyecto, String codigoError) {
		return "https://baz-developer.bancoazteca.com.mx/info#500." + nombreProyecto + ".500"  + codigoError;
	}
	
}
