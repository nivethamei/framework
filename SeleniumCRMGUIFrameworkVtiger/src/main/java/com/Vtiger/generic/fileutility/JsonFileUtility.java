package com.Vtiger.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable, IOException, ParseException {
		JSONParser jp=new JSONParser();
		Object jobj = jp.parse(new FileReader("./ConfAppData/appcommondata.json"));
		
		JSONObject map=(JSONObject)jobj;
		String  data = (String) map.get(key);
		return data;
	}

}
