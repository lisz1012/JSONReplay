package com.lisz.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONConverter {
	private static Gson gson = new GsonBuilder().create();
	
	public static String toJsonString(Transaction transaction) {
		return gson.toJson(transaction);
	}
	
	public static <T> T toObject(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
}
