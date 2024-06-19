package com.betcacom.car;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.betcacom.car.exception.AcademyException;
import com.betcacom.car.oggetti.*;
import com.betcacom.car.service.implementation.*;
import com.betcacom.car.service.interfaces.*;
import com.betcacom.car.singleton.MySingleton;
//import com.betcacom.car.singleton.MySingleton;



public class Main {

	static IGestioneVeicolo gmac = new GestioneMacchina();
	static IGestioneVeicolo gmot = new GestioneMoto();
	static IGestioneVeicolo gbici = new GestioneBici();
	private static IGestioneSystem gsys = new GestioneSystem();


	public static void main(String[] args) {
		
		
		//-----MACCHINA----
		
		//BELLA
		Macchina paramCar = new Macchina();
		paramCar.setNumeroPorte(4);
		paramCar.setCc(123);
		paramCar.setColore("blue");
		paramCar.setMarca("ferrari");
		paramCar.setNumeroRuote(4);
		paramCar.setNumerotarga("AB678CD");
		paramCar.setTipoAlimentazione("benzina");
		paramCar.setTipoVeicolo("utilitaria");
		paramCar.setDtaInserimento(new Date());
		paramCar.setDataDopoMese();
		Macchina mac = null;
		mac = createMacchina(paramCar);
		
		Macchina paramCar2 = new Macchina();
		paramCar2.setNumeroPorte(4);
		paramCar2.setCc(123);
		paramCar2.setColore("viola");
		paramCar2.setMarca("Ferrari");
		paramCar2.setNumeroRuote(4);
		paramCar2.setNumerotarga("AB678CD");
		paramCar2.setTipoAlimentazione("benzina");
		paramCar2.setTipoVeicolo("sportiva");
		paramCar2.setDtaInserimento(new Date());
		paramCar2.setDataDopoMese();
		Macchina mac2 = null;
		mac2 = createMacchina(paramCar2);
		
		Macchina paramCar3 = new Macchina();
		paramCar3.setNumeroPorte(4);
		paramCar3.setCc(123);
		paramCar3.setColore("giallo");
		paramCar3.setMarca("Ferrari");
		paramCar3.setNumeroRuote(4);
		paramCar3.setNumerotarga("AB678CD");
		paramCar3.setTipoAlimentazione("gas");
		paramCar3.setTipoVeicolo("fuoristrada");
		paramCar3.setDtaInserimento(new Date());
		paramCar3.setDataDopoMese();

		Macchina mac3 = null;
		mac3 = createMacchina(paramCar3);
		
		//BRUTTA
		Macchina paramnull = new Macchina();
		Macchina brutta = null;
		brutta = createMacchina(paramnull);
		

		
		
		//------MOTO-----
		
		//BELA
		Moto paramBike = new Moto();
		paramBike.setCc(3000);
		paramBike.setDtaInserimento(new Date());
		paramBike.setMarca("Ducati");
		paramBike.setColore("rossa");
		paramBike.setTipoAlimentazione("benzina");
		paramBike.setNumeroRuote(2);
		paramBike.setNumeroTarga("SASSO");
		paramBike.setTipoVeicolo("corsa");
		paramBike.setDataDopoMese();
		Moto bike = createMoto(paramBike);
		
		
		
		//------BICI-----
		Bici paramBici = new Bici();
		paramBici.setCestino(false);
		paramBici.setColore("giallo");
		paramBici.setTipoAlimentazione("manuale");
		paramBici.setDtaInserimento(new Date());
		paramBici.setMarca("Aurora");
		paramBici.setNumeroRuote(9);
		paramBici.setPieghevole(true);
		paramBici.setSospensioni("avanti");
		paramBici.setTipoUso("no");
		paramBici.setTipoVeicolo("pista");
		paramBici.setDataDopoMese();

		Bici biciclettaassurda = createBici(paramBici);
		
		
		//System.out.printl();
		
		Macchina.statistiche();
		System.out.println();
		System.out.println();
				
		//-------------SINGLETON------------------------
		

		List <Veicolo> listav = gsys.getList();
		System.out.println();
		
		display();
		
		System.out.println();
		RemoveMoto(4);
		RemoveMacchina(2);
		System.out.println();
		System.out.println();
		display();

		
		Veicolo v1 = getMachina(5);
		Veicolo v2 = getMoto(4);
		Veicolo v3 = getBici(5);
//		if(v1 != null) {
//			v1.stampa();
//		}
		
		
		
	}
	
	
	

	//-------------------MACCHINA--------------------------
	private static Macchina createMacchina(Macchina paramCar) {
		Macchina mac = null;
		try{
			mac =(Macchina)gmac.createVeicolo(paramCar);
		} catch(AcademyException e) {
			System.out.println(e.getMessage());
		} finally {
			//System.out.println("finnaly!!!");

		}
		return mac;
	}
	private static void RemoveMacchina (Integer id) {
		try {
			gmac.removeVeicolo(id);
			
		}catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static Macchina getMachina(Integer id) {
		Macchina s = null;
		try {			
			s = (Macchina)gmac.getVeicolo(id);
		}catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	
	//-------------------MOTO-----------------------------
	
	private static Moto createMoto(Moto paramCar) {
		Moto bike = null;
		try{
			bike =(Moto)gmot.createVeicolo(paramCar);
		} catch(AcademyException e) {
			System.out.println(e.getMessage());
		} finally {
			//System.out.println("finnaly!!!");

		}
		return bike;
	}
	
	private static void RemoveMoto (Integer id) {
		try {
			gmot.removeVeicolo(id);
			
		}catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static Moto getMoto(Integer id) {
		Moto s = null;
		try {			
			s = (Moto)gmot.getVeicolo(id);
		}catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	
	//-----------------BICI----------------------------------
	private static Bici createBici(Bici paramCar) {
		Bici mac = null;
		try{
			mac =(Bici)gbici.createVeicolo(paramCar);
		} catch(AcademyException e) {
			System.out.println(e.getMessage());
		} finally {
			//System.out.println("finnaly!!!");

		}
		return mac;
	}
	
	private static void RemoveBici (Integer id) {
		try {
			gbici.removeVeicolo(id);
			
		}catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static Bici getBici(Integer id) {
		Bici s = null;
		try {			
			s = (Bici)gbici.getVeicolo(id);
		}catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	private static void display1() {
		SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy", new Locale("it"));
		System.out.println("Dysplaylist");
		for(Veicolo v : gsys.getList()) {
			System.out.println(v.getId() +" data "+ v.getDtaInserimento() +  ", data dopo un mese: " + df.format(v.getDataDopoMese()));		//giorno, nome del mese e anno(italiano) + data dopo un mese
		}
		
	}
	
	private static void display() {
		gsys.getList().stream().forEach(v -> System.out.println(v.getId() +" data "+ v.getDtaInserimento() +  ", data dopo un mese: " + new SimpleDateFormat("dd MMMM yyyy", new Locale("it")).format(v.getDataDopoMese())));
	}

}
