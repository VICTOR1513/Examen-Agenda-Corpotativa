package com.examen.agenda.corpotativa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomStringGenerator {

	public String getRandomString() {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString().substring(0, 20);
	}

	public String folioSalida() {	
		String folio = "";
		Date date = new Date();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String strDate = formatter.format(date);
			String cadenaalfanumerica = getRandomString();
			folio = cadenaalfanumerica + "*" + strDate;
		} catch (Exception e) {
		}
		return folio;
	}

}
