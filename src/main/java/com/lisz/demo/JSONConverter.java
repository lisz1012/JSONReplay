package com.lisz.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.lisz.model.Person;

public class JSONConverter {
	private static Gson gson = new GsonBuilder().create();
	
	public static String toJsonString(Transaction transaction) {
		return gson.toJson(transaction);
	}
	
	public static <T> T toObject(String jsonString, Class<T> clazz) {
		
		return gson.fromJson(jsonString, clazz);
	}
	
	public static Person[] toPersonArray(File file) {
		List<Person> persons = new ArrayList<>();
		try {
			JsonReader reader = gson.newJsonReader(new FileReader(file));
			reader.beginArray();
			while (reader.hasNext()) {
				Person person = gson.fromJson(reader, Person.class);
				persons.add(person);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person arr[] = new Person[persons.size()];
		int i = 0;
		for (i = 0; i < persons.size(); i++) {
			arr[i] = persons.get(i);
		}
		return arr;
	}
}
