package com.examen.agenda.corpotativa.utils;

public enum enumUtil {

	ESTATUS_PENDIENTE(1), ESTATUS_CONFIRMADO(2), TIPO_SOLICITUD_MIXTO(4), VALUE_ZERO(0);

	public final int ID;

	private enumUtil(int ID) {
		this.ID = ID;
	}

}
