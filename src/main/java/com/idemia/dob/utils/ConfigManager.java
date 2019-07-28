package com.idemia.dob.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigManager {
static Properties properties;
	
	public static void loadConfig()
	{
		try {
			File file = new File("Config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			
			Properties properties = new Properties();
			properties.load(fileInput);
			ConfigManager.properties = properties;
		
			
		} catch (Exception e) {
			System.out.println("Exception occurred while loading config.properties "+ e.getMessage());
		}
		
	}
	
	public static String getProperty(String key)
	
	{
        
		try
		{
			loadConfig();
		return properties.getProperty(key);
		}catch (Exception e) {
			return null;
		}
		
	}
	
	public static void setProperty(String key, String value) throws FileNotFoundException
	{
		
		try {
			FileInputStream in = new FileInputStream("Config.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream("Config.properties");
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();;
			
			
		}
	}
	

}
