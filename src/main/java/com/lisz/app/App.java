package com.lisz.app;

import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.lisz.demo.StripeAPIClient;
import com.lisz.model.Pair;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class App {
	private static Gson gson = new GsonBuilder().create();
	private static OkHttpClient client = new OkHttpClient();
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static StripeAPIClient stripeAPIClient = new StripeAPIClient();
	
    public static void main( String[] args ) throws Exception {
    	JsonReader reader = new JsonReader(new FileReader(new File("request-2.json")));
		reader.beginArray();
		while (reader.hasNext()) {
			JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
			//System.out.println("request: " + jsonObject);
			JsonObject requestJsonObject = jsonObject.getAsJsonObject("request");
			JsonObject responseJsonObject = jsonObject.getAsJsonObject("response");
			System.out.println("Request: \n" + requestJsonObject);
			System.out.println("Response: \n" + responseJsonObject);
			//Response response = gson.fromJson(responseJsonObject.toString(), Response.class);
			/*Request request = objectMapper.readValue(requestJsonObject.toString(), Request.class);
			Response response = objectMapper.readValue(responseJsonObject.toString(), Response.class);
			request.getTags$okhttp();
			System.out.println("req: \n" + request);
			System.out.println("response: \n" + response);*/
			//JsonObject headersJsonObject = requestJsonObject.getAsJsonObject("headers");
			//headersJsonObject.get("").get
			String url = "https://api.stripe.com" + requestJsonObject.get("url").getAsString();
			System.out.println(url);
			//JsonObject headersJsonObject = requestJsonObject.getAsJsonObject("headers");
			//Headers headers = gson.fromJson(headersJsonObject.toString(), Headers.class);
			//System.out.println(headers);
			
			//String url = requestJsonObject.getAsJsonObject("url").getAsString();
			String responseStr = stripeAPIClient.post(url, requestJsonObject.get("body").getAsString());
			System.out.println(responseStr);
			/*
			//Response expectedResponse = gson.fromJson(reader, Response.class);
			///Response actualResponse = client.newCall(request).execute();
			//System.out.println("Expected: \n" + expectedResponse);
			//System.out.println("Actual: \n" + actualResponse);*/
		}
		reader.close();
    	
    	/*String content= FileUtils.readFileToString(new File("request-3.json"), "UTF-8");
        Request request = gson.fromJson(content, Request.class);
        System.out.println(request);*/
    }
}
