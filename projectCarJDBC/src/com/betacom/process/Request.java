package com.betacom.process;

import java.util.List;

import com.betacom.exception.SQLAcademyException;

public class Request {

	
	public void checkDelete(List<String> l) throws SQLAcademyException {
		
		//lunghezza della lista
		
		if(l == null) {
			throw new SQLAcademyException("Operazione delete non trovata");
		}else if(!(l.get(0).equalsIgnoreCase("macchina") || l.get(0).equalsIgnoreCase("moto")) || l.get(0).equalsIgnoreCase("bici")) {
			throw new SQLAcademyException("Veicolo di delete non conforme");
		}else if( ! (l.get(1) instanceof String)) {
			throw new SQLAcademyException("Id della delete deve essere un numero");
		}
	}
}
