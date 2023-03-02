package com.examen.agenda.corpotativa.utils;
//package com.baz.pagosfisicos.utils;
//
//import java.util.List;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonSyntaxException;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class JsonUtil {
//
//	public static <T> T jsonToObject(String json, Class<T> Type) {
//		return new Gson().fromJson(getJsonObject(json, "resultado"), Type);
//	}
//
//	private static JsonObject getJsonObject(String json, String nombreElement) {
//		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
//		JsonObject jsonObjectData = jsonObject.getAsJsonObject(nombreElement);
//		return jsonObjectData.isJsonNull() ? new JsonObject() : jsonObjectData;
//	}
//
//	public static boolean jsonIsValido(String json) {
//		try {
//			String jsonFormattedString = limpiarJson(json);
//			log.info("JSON con formato correcto: " + jsonFormattedString);
//			JsonParser.parseString(limpiarJson(jsonFormattedString));
//		} catch (JsonSyntaxException e) {
//			log.error("JSON con formato incorrecto: " + e);
//			return false;
//		}
//		return true;
//	}
//
//	public static String limpiarJson(String json) {
//		return json.replaceAll("\\\\", "");
//	}
//
//	public static <T> String listObjectToJson(List<T> type) {
//		return new Gson().toJson(type);
//	}
//	
//	
//	   public static <T> T jsonStringToObject(String json, Class<T> type) {
//	        return new Gson().fromJson(json, type);
//	    }
//
//}
