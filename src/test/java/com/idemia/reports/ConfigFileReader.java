package com.idemia.reports;

import com.idemia.dob.utils.ConfigManager;

public class ConfigFileReader 
	{

	public  static String getReportConfigPath(){
		String reportConfigPath = ConfigManager.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
