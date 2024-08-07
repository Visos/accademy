package com.betacom.fe.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WebUtils {
	//updateSocio crea problemi perché si aspetta un Json, ma noi lavoriamo con oggetti
	//cerchiamo di trasformare il json in oggetto
	
	public static Object convertInObject(Object inp, Class<?> tipo) {
		Object resp = new Object();
		
		//jackson è alla base di tutti i parser utilizzati per le trasformazioni 
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			resp = mapper.convertValue(inp, tipo);
			
		} catch (Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
		return resp;
	}

}
