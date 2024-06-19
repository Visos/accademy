package com.betcaom.thread.attivita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import dto.Pianificazione;
import dto.Richiesta;
import model.Attività;
import model.Istruttore;
import service.PianificazioneService;
import utilities.Utilities;

public class MainAttivita extends Utilities implements Runnable {

	public void startAttivita() {
		
		final String attivitàPath = "C:\\Users\\Betacom\\Documents\\GitHub\\accademy\\projectThread\\src\\com\\betcaom\\thread\\attivita\\attività.txt";
		final String istruttoriPath = "C:\\Users\\Betacom\\Documents\\GitHub\\accademy\\projectThread\\src\\com\\betcaom\\thread\\attivita\\istruttori.txt";
		List<String> input;
		List<Attività> att;
		input = readLine(attivitàPath);
		att = loadAttività(input);
		System.out.println("numero attività: " + att.size());
		
		List<Istruttore> ist;
		input = readLine(istruttoriPath);
		ist = loadIstruttore(input);
		System.out.println("numero istruttori: " + ist.size());
		
		Richiesta riL = new Richiesta("Create", "Lun", 18, 2, 6);
		Richiesta riMa = new Richiesta("Create", "Mar", 10, 1, 4);
		Richiesta riMe = new Richiesta("Create", "Mer", 15, 3, 2);
		Richiesta riGio = new Richiesta("Create", "Gio", 10, 4, 1);
		Richiesta riVen = new Richiesta("Create", "Ven", 20, 5, 3);
		Richiesta riSab = new Richiesta("Create", "Sab", 11, 6, 5);
		Richiesta riDom = new Richiesta("Create", "Dom", 17, 7, 5);
		
		Richiesta dL = new Richiesta("Remove", "Lun", 18, 2, 6);//attualmente tipo richiesta invalido.
		Richiesta dDom = new Richiesta("Remove", "Dom", 17, 7, 5);
		
		Pianificazione pf = new Pianificazione();
		
		pf = new PianificazioneService().pianificazioneManager(riL, ist, att, pf); 
		pf = new PianificazioneService().pianificazioneManager(riMa, ist, att, pf);
		pf = new PianificazioneService().pianificazioneManager(riMe, ist, att, pf);
		pf = new PianificazioneService().pianificazioneManager(riGio, ist, att, pf);
		pf = new PianificazioneService().pianificazioneManager(riVen, ist, att, pf);
		pf = new PianificazioneService().pianificazioneManager(riSab, ist, att, pf);
		pf = new PianificazioneService().pianificazioneManager(riDom, ist, att, pf);
		
		System.out.println("************ Pianificazione settimana **********************");
		System.out.println(pf);
		System.out.println("************** Remove pianificazione lunedi e domenica ********************");
		
		pf = new PianificazioneService().pianificazioneManager(dL, ist, att, pf);
		pf = new PianificazioneService().pianificazioneManager(dDom, ist, att, pf);
		
		System.out.println(pf);
		
		Richiesta rA = new Richiesta("RemoveAll", (String)null, (Integer)0, (Integer)0, (Integer)0);
		pf = new PianificazioneService().pianificazioneManager(rA, ist, att, pf);
		
		System.out.println(pf);
		
	}

	private  List<Attività> loadAttività(List<String> input) {
		return input.stream().map(it -> {
			Attività att = new Attività();
			String[] token = it.split(",");
			att.setId(Integer.parseInt(token[0]));
			att.setAttività(token[1]);
			return att;
		}).collect(Collectors.toList());
	}
	
	private  List<Istruttore> loadIstruttore(List<String> input) {
		return input.stream().map(it -> {
			Istruttore ist = new Istruttore();
			String[] token = it.split(",");
			ist.setId(Integer.parseInt(token[0]));
			ist.setNome(token[1]);
			ist.setCognome(token[2]);
			ist.setIdAttività(Integer.parseInt(token[3]));
			return ist;
		}).collect(Collectors.toList());
	}

	@Override
	public void run() {
		
		Random rand = new Random();
		System.out.println("******************partito thread Azienda************************");
		
		try {
			Thread.sleep(rand.nextInt(1000, 1700));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		startAttivita();
		
		System.out.println("******************finito thread Azienda************************");

	}
}
