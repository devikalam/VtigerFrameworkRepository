package com.vtiger.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fir=new FileReader("./jsondata/appCommonData1.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fir);
		JSONObject js=(JSONObject)obj;
		String data = (String)js.get(key);
		return data;
	
		
		
	}

}
