package com.betcacom.car.utility;

import com.betcacom.car.oggetti.Veicolo;

public class Verify {
	
	public String checkVeicolo(Veicolo a, String error) {	
		

		if(a.getNumeroRuote() == null || a.getNumeroRuote() < 0) {
			error+= "n. ruote obbligatorio, ";
		}
		if(a.getColore() == null) {
			error+= "colore obbligatorio, ";
		}
		if(a.getDtaInserimento() == null) {
			error+= "data obbligatorio, ";
		}
		if(a.getDataDopoMese() == null) {
			error+= "datadopoMese obbligatorio, ";
		}

		
		return error;
	}

}
