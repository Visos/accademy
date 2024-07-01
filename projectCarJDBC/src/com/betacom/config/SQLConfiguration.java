package com.betacom.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.betacom.exception.SQLAcademyException;

public class SQLConfiguration {

	private static String url;
	private static String driver;
	private static String user;
	private static String pwd;
	private static String delete;
	private static String select;
	private static String insert_macchina;
	private static String insert_veicolo;
	private static String update;


	
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
			select = prop.getProperty("slct");
			insert_macchina = prop.getProperty("insm");
			insert_veicolo = prop.getProperty("insv");
			delete = prop.getProperty("delt");
			update = prop.getProperty("updt");

			
			
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
	
	public String getSelect() {
		return select;
	}
	public String getInsertMacchina() {
		return insert_macchina;
	}
	public String getInsertVeicolo() {
		return insert_veicolo;
	}
	public String getDelete() {
		return delete;
	}
	public String getUpdate() {
		return update;
	}
	
}
