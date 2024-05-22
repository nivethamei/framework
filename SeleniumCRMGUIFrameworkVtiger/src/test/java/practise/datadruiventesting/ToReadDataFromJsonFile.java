package practise.datadruiventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ToReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		//step1:convert the json object file into java object file using JSONPARSER class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\Nivetha Shanmugam\\Desktop\\appcommondata.json"));
		
		//Step2:covert the java Object into JsonObject by downcasting
		JSONObject map=(JSONObject)obj;
		
		//Step3:call the get method
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
		
		
		
      
	}

}
