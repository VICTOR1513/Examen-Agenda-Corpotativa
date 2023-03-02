package com.examen.agenda.corpotativa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DateUtil {


	private static  final String FFORMAT_HHMMSSS = "HH:mm:ss";
	private static  final String FFORMAT_YYYYYMMDDHHMMSSS = "yyyy-MM-dd'T'HH:mm:ss";
	private static  final String FFORMAT_YYYYYMMDD = "yyyy-MM-dd";

	public static String getFechaConsulta(String fecha) {
		String fechafinal = "";

		try {
			DateFormat formatter = new SimpleDateFormat(FFORMAT_YYYYYMMDD);
			Date date = formatter.parse(fecha);

			if (verificarFechaEntreDosFechas(obtenerFechaConHoraDoce(date), obtenerFechaConHoraCero(new Date()),
					obtenerFechaConHoraVeintiCuatro(new Date()))) { // DENTRO DEL MISMO DIA
				fechafinal = fecha.concat(" ").concat(stringDateFormat(new Date(), FFORMAT_HHMMSSS));
			} else {

				if (date.after(new Date())) { // LA FECHA QUE LLEGA ES MAYOR A LA DE HOY SI ENTRA
					fechafinal = fecha.concat(" ").concat(stringDateFormat(new Date(), FFORMAT_HHMMSSS));
				} else {// FECHA DE AYER
					SimpleDateFormat F = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					return F.format(obtenerFechaConHoraVeintiCuatro(date));
				}
			}
		} catch (ParseException e) {
			log.error("Error: "+ ExceptionUtils.getStackTrace(e));
		}

		return fechafinal;

	}

	private static boolean verificarFechaEntreDosFechas(Date fechaVerificar, Date inicio, Date fin) {
		long miliEvaluar = fechaVerificar.getTime();
		long miliInicio = inicio.getTime();
		long miliFin = fin.getTime();
		return miliEvaluar >= miliInicio && miliEvaluar <= miliFin;
	}

	private static Date obtenerFechaConHoraDoce(Date fecha) {
		Calendar calinicio = Calendar.getInstance();
		calinicio.setTime(fecha);
		calinicio.set(Calendar.HOUR_OF_DAY, 12);
		calinicio.set(Calendar.HOUR, 0);
		calinicio.set(Calendar.AM_PM, Calendar.PM);
		calinicio.set(Calendar.MINUTE, 0);
		calinicio.set(Calendar.SECOND, 0);
		fecha = calinicio.getTime();
		return fecha;
	}

	private static Date obtenerFechaConHoraCero(Date fecha) {
		Calendar calinicio = Calendar.getInstance();
		calinicio.setTime(fecha);
		calinicio.set(Calendar.HOUR_OF_DAY, 0);
		calinicio.set(Calendar.HOUR, 0);
		calinicio.set(Calendar.AM_PM, Calendar.AM);
		calinicio.set(Calendar.MINUTE, 0);
		calinicio.set(Calendar.SECOND, 0);
		fecha = calinicio.getTime();
		return fecha;
	}

	private static Date obtenerFechaConHoraVeintiCuatro(Date fecha) {
		Calendar calfin = Calendar.getInstance();
		calfin.setTime(fecha);
		calfin.set(Calendar.HOUR_OF_DAY, 23);
		calfin.set(Calendar.HOUR, 11);
		calfin.set(Calendar.AM_PM, Calendar.PM);
		calfin.set(Calendar.MINUTE, 59);
		calfin.set(Calendar.SECOND, 59);
		fecha = calfin.getTime();
		return fecha;
	}
	
	private static String stringDateFormat(Date fecha, String formato) {
	      SimpleDateFormat formatter = new SimpleDateFormat(formato);
          return formatter.format(fecha);
	}
	
	public static String timeFronDate(String fecha) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(FFORMAT_YYYYYMMDDHHMMSSS);
            Date parse = format.parse(fecha);
            return stringDateFormat(parse, FFORMAT_HHMMSSS);
        } catch (ParseException e) {
        	log.error("Error: "+ ExceptionUtils.getStackTrace(e));
        }
        return null;
    }
	
	public static String dateFronDateTime(String fecha) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(FFORMAT_YYYYYMMDDHHMMSSS);
            Date parse = format.parse(fecha);
            return stringDateFormat(parse, FFORMAT_YYYYYMMDD);
        } catch (ParseException e) {
        	log.error("Error: "+ ExceptionUtils.getStackTrace(e));
        }
        return null;
    }
	

}
