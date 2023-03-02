package com.examen.agenda.corpotativa.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqlServerUtil {

	private static String DECLARE = "DECLARE ";
	private static String AS = " AS ";
	public static String OUTPUT = " OUTPUT ";
	private static String SQL_FETCH_NEXT_FROM = " FETCH NEXT FROM ";
	private static String SQL_INTO = " INTO ";
	private static String SQL_WHILE = " WHILE ";
	private static String SQL_BEGIN = " BEGIN ";
	private static String SQL_SELECT = " SELECT ";
	private static String SQL_END = " END ";

	public static String TYPE_INT = " INT ";
	public static String TYPE_SMALLINT = " SMALLINT ";
	public static String TYPE_VARCHAR_20 = " VARCHAR(20) ";
	public static String TYPE_VARCHAR_50 = " VARCHAR(50) ";
	public static String TYPE_VARCHAR_100 = " VARCHAR(100) ";
	public static String TYPE_VARCHAR_500 = " VARCHAR(500) ";
	public static String TYPE_DATETIME = " DATETIME ";
	public static String TYPE_NUMERIC = " NUMERIC(14,2) ";
	public static String TYPE_CURSOR = " CURSOR ";
	public static String TYPE_CONTENEDOR = "TY_CONTENEDOR";
	public static String TYPE_DENOMINACION = "TY_DENOMC";

	// public static String GET_FECHA_ACTUAL_SISTEMA = DECLARE + "@vl_fecha DATETIME
	// = GETDATE() ";
	public static String GET_USUARIO_SISTEMA = DECLARE + "@vl_user VARCHAR(15) = SYSTEM_USER ";
	public static String GET_RETURN_VALUE = "@return_value";
	public static String GET_CODIGO = "@ps_codigo";
	public static String GET_MENSAJE = "@ps_mensaje";
	public static String GET_CONTENEDOR = "@vl_conten";
	public static String GET_DENOMINACION = "@vl_denom";
	public static String GET_FECHA = "@vl_fecha";
    /* SOLICITUDES */
	public static String FIIDTIPODISPOSITIVO = "@tipo_disp";
	public static String FCNOMDISPOSITIVO = "@nom_disp";
	public static String FCIDDISPOSITIVO = "@id_disp";
	public static String FCEMPLEADODISP = "@emp_disp";
	public static String FIIDTIPOSOLICITUD = "@id_tiposol";
	public static String FCTIPOSOLICITUD = "@tipo_sol";
	public static String FIIDSOLICITUDOPERA = "@id_solopera";
	public static String FCSOLICITUDOPERA = "@solopera";
	public static String FNNUMSOLICITUD = "@numsol";
	public static String FIIDDIVISA = "@id_divisa";
	public static String FCABREVIATURA = "@divisa";
	public static String FIIDESTATUS = "@id_estatus";
	public static String FCNOMESTATUS = "@estatus";
	public static String FNSALDOSOLICITADO = "@saldo_solicitado";
	public static String FDFECHASOLICITUD = "@fecha_sol";
	public static String FDFECHAAUTORIZA = "@fecha_autoriza";
	public static String FCEMPLEADOAUTORIZA = "@emp_autoriza";
	public static String FCEMPLEADO = "@emp";
	public static String FIIDOPERACIONORIGEN = "@id_oporigen";
	public static String FCOPERACIONORIGEN = "@oper_origen";
	/* SOLICITUDES DETALLES DENOMINACIONES */
	public static String FIIDTIPOCONTENEDOR = "@tipo_cont";
	public static String FIIDDENOM = "@id_denom";
	public static String FNTIPODENOM = "@tipo_denom";
	public static String FNPIEZAS = "@piezas";
	
	public static String GET_PS_SOLICITUD = "@ps_Solicitud";
	public static String GET_PS_DENOMINACION = "@ps_Denom";

	public static String declarVarchar(String variable, String type) {
		return DECLARE.concat(variable).concat(type).concat("; ");
	}

	public static String declareInt(String variable) {
		return DECLARE.concat(variable).concat(TYPE_INT).concat("; ");
	}

	public static String declareSmallint(String variable) {
		return DECLARE.concat(variable).concat(TYPE_SMALLINT).concat("; ");
	}
	
	public static String declareNumeric(String variable) {
		return DECLARE.concat(variable).concat(TYPE_NUMERIC).concat("; ");
	}

	public static String declareDateTime(String variable) {
		return DECLARE.concat(variable).concat(TYPE_DATETIME).concat(" = GETDATE() ").concat("; ");
	}

	public static String declareCursor(String variable) {
		return DECLARE.concat(variable).concat(TYPE_CURSOR).concat("; ");
	}

	public static String declareType(String variable, String type, List<List<Integer>> listas) {
		return DECLARE.concat(variable).concat(AS).concat(type).concat(" INSERT ").concat(variable).concat(" VALUES ")
				.concat(getArrayType(listas)).concat("; ");
	}

	public static String getResulCodigoMensje() {
		return "SELECT ".concat(GET_CODIGO).concat(AS).concat("N").concat("'").concat(GET_CODIGO).concat("', ")
				.concat(GET_MENSAJE).concat(AS).concat("N").concat("'").concat(GET_MENSAJE).concat("' ; ");
	}

	private static String getArrayType(List<List<Integer>> listas) {
		StringBuilder arraySQL = new StringBuilder("");
		listas.stream().forEach(lista -> {
			StringBuilder cadena = new StringBuilder("");
			if (lista != null) {
				lista.stream().forEach(id -> {
					setSeparadorComa(cadena);
					cadena.append(id.toString());
				});
			}
			setSeparadorComa(arraySQL);
			arraySQL.append("(".concat(cadena.toString()).concat(")"));
		});
		return arraySQL.toString();
	}

	private static void setSeparadorComa(StringBuilder cadena) {
		if (!"".equals(cadena.toString())) {
			cadena.append(",");
		}
	}

	public static String getResulCursor(String cursor, String... args) {
		StringBuilder cadena = new StringBuilder("");
		StringBuilder cadenaAlias = new StringBuilder("");
		for (String text : args) {
			setSeparadorComa(cadena);
			setSeparadorComa(cadenaAlias);
			cadena.append(text);
			cadenaAlias.append(text).append(AS).append("N").append("'").append(text).append("'");
		}
		return  SQL_FETCH_NEXT_FROM
				.concat(cursor)
				.concat(SQL_INTO)
				.concat(cadena.toString())
				.concat(SQL_WHILE)
				.concat("@@FETCH_STATUS = 0")
				.concat(SQL_BEGIN)
				.concat(SQL_SELECT)
				.concat(cadenaAlias.toString())
				.concat(SQL_FETCH_NEXT_FROM)
				.concat(cursor)
				.concat(SQL_INTO)
				.concat(cadena.toString())
				.concat(SQL_END);
	}

	public static String getHeader(ResultSet rs) {
		StringBuilder cadena = new StringBuilder("");
		try {
			for (int x = 1; x <= rs.getMetaData().getColumnCount(); x++) {
				setSeparadorComa(cadena);
				cadena.append(rs.getMetaData().getColumnName(x));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadena.toString();
	}

}
