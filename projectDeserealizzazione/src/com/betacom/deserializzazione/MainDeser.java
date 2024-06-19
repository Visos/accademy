package com.betacom.deserializzazione;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.betacom.serializzazione.Adress;

public class MainDeser {
	
	public static void main(String[] args) {
	
		Adress adress;
		String filePath = "C:\\Users\\Betacom\\Documenti\\Gfile\\adress.ser";		

		
		try {
			FileInputStream fout = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fout);
			adress = (Adress) ois.readObject();
			ois.close();
			
			System.out.println(adress);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}

}
