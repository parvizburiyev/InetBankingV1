package com.InetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			} catch(Exception e){
				System.out.println("Exception is " + e.getMessage());
			}
	}
	
	
	public String GetApplicationUrl() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String userName = pro.getProperty("userName");
		return userName;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChropath() {
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getIepath() {
		String ie = pro.getProperty("iepath");
		return ie;
	}
	
	public String getFirefoxpath() {
		String firefox = pro.getProperty("firefoxpath");
		return firefox;
	}

}
