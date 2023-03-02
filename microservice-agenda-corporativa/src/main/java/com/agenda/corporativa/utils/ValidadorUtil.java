package com.agenda.corporativa.utils;

import java.math.BigDecimal;
import java.util.Collection;

public class ValidadorUtil {

	public static String bigDecimalToString(BigDecimal value) {
		return value != null ? value.toString() : BigDecimal.ZERO.toString();
	}

	public static BigDecimal stringToBigDecimal(String campo) {
		return validarString(campo) ? new BigDecimal(campo) : BigDecimal.ZERO;
	}

	public static boolean validarString(String campo) {
		return campo != null ? !campo.equals("") && !campo.trim().isEmpty() : false;
	}

	public static boolean isEmptyObject(Object obj) {
		return obj == null || obj.toString().trim().isEmpty();
	}

	public static boolean isEmptyCollection(Collection<?> obj) {
	    return obj == null || obj.isEmpty();
	}

	public static boolean isEmptyString(String string) {
	    return string == null || string.trim().isEmpty();
	}

//	public static boolean isEmpty(Object obj) {
//	    return obj == null || obj.toString().trim().isEmpty();
//	}
}
