package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./configAppData/data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String data = pro.getProperty(key);
		return data;
		}

}
