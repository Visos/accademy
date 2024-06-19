package com.betacom.serializzazione;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainSer {
	
	public static void main(String[] args) {
	
		String filePath = "C:\\Users\\Betacom\\Documenti\\Gfile\\adress.ser";		

		Adress adress = new Adress();
		
		adress.setCity("Venice");
		adress.setStreet("via centrale");
		adress.setName("Gigi");
		
		
		try {
			
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream obj = new ObjectOutputStream(fout);
			obj.writeObject(adress);
			obj.close();
			
			
			System.out.println("Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
