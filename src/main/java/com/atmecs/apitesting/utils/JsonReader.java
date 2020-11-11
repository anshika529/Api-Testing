package com.atmecs.apitesting.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;

public class JsonReader {
String jsonFilePath;
	
	public JsonReader(String jsonFilePath) {
		this.jsonFilePath = jsonFilePath;
	}
	
	public Object parse() throws org.json.simple.parser.ParseException {
		JSONParser parser = new JSONParser();
		Object object = null;
		try {
			object = parser.parse(new FileReader(new File(jsonFilePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
}
