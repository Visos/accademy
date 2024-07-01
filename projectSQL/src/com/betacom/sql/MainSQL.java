package com.betacom.sql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.betacom.sql.config.SQLConfiguration;

public class MainSQL {
	
	


	public static void main(String[] args) {
		
		
		
		try {
			Properties prop = new Properties();
			InputStream stream = new FileInputStream("./sql.proprieties");
			prop.load(stream);
			
			
			System.out.println("url: " + prop.getProperty("url"));
		} catch (Exception e) {
			System.out.println("error loading properties file");
			e.printStackTrace();
		}
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("query Q -update U  -transaction T");
		String option = input.nextLine();
		SQLProcess pro = null;
		
		if(option.equalsIgnoreCase("q")) pro = new ProcessQuery();
		else if(option.equalsIgnoreCase("u")) pro = new ProcessUpdate();
		else if(option.equalsIgnoreCase("t")) pro = new processTransaction();

		
		pro.execute();
		
		
		System.out.println("end of process.....");
		
		
		
	}

}
