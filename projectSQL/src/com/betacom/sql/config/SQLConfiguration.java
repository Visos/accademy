package com.betacom.sql.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.betacom.sql.exception.SQLAcademyException;

public class SQLConfiguration {

	private static String url;
	private static String driver;
	private static String user;
	private static String pwd;

	
	public static SQLConfiguration instance;
	private static Properties prop;		//forse è diverso
	
	private SQLConfiguration() {
		
	}

	
	public static SQLConfiguration getInstance() throws SQLAcademyException{
		if(instance == null) {
			instance = new SQLConfiguration();
			loadConfiguration();
		}
		return instance;
	}
	
	private static void loadConfiguration() throws SQLAcademyException{
		
		try {
			Properties prop = new Properties();
			InputStream stream = new FileInputStream("./sql.proprieties");
			prop.load(stream);
			
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");
			
			System.out.println("url: " + prop.getProperty("url"));
		} catch (Exception e) {
			System.out.println("error loading properties file");
			e.printStackTrace();
			throw new SQLAcademyException();
		}
		

	}
	public String getUrl() {
		return url;
	}

	public String getDriver() {
		return driver;
	}

	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}

	public String getProperties(String p) {
		return prop.getProperty(p);
	}
	
	
	
	
}
