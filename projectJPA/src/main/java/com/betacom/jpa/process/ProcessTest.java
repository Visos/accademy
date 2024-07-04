package com.betacom.jpa.process;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Certificato;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import com.betacom.jpa.service.interfaces.ICertificatoService;
import com.betacom.jpa.service.interfaces.ISocioService;

@Service
public class ProcessTest {
	
	@Autowired
	private ISocioService socioS;
	
	@Autowired
	private ICertificatoService certifS;
	
	@Autowired
	private IAbbonamentoService abboS;
	
	public static Logger log = LoggerFactory.getLogger(ProcessTest.class);
	public static List<Integer> idC = new ArrayList<Integer>();
	public static List<Integer> idS = new ArrayList<Integer>();
	
	public void createNewSocio() {
		


		//socioProcess();
		//certificatoProcess();
		
		listSocio();
		listCertificato();
		createAbbonamento("09/05/2024", idS.get(0));
		createAbbonamento("02/06/2024", idS.get(0));


		//removeCertificato(idC.get(0));
		//removeSocio(idS.get(1));
		updateSocio(idS.get(2), "gino", "postino");
		
		listSocio();
		

		

		
//		lS = socioS.serachCognome("verdi");
//		lS.forEach(s->System.out.println("Lista dei bro col cognome: " + s.toString()));
		
		
//		prova con i cognomi
//		List<String> p = new ArrayList<String>();
//		p.add("Verdi");
//		p.add("Bianchi");		
//		List<SocioDTO> sCI = socioS.serachCognomi(p);
//		sCI.forEach(s->System.out.println("Lista dei cognomi: " + s.toString()));

		



	}
	
	private void socioProcess() {
		log.debug("Beigin create socio");

		
		SocioDTO input = new SocioDTO();
		input.setcFiscale("234567898765");
		input.setCognome("Verdi");
		input.setNome("Gianni");
		
		idS.add(socioS.createSocio(input));
		
		input = new SocioDTO();
		input.setcFiscale("234590898765");
		input.setCognome("Rossi");
		input.setNome("Paolo");
		
		idS.add(socioS.createSocio(input));
		
		input = new SocioDTO();
		input.setcFiscale("847528202");
		input.setCognome("Bianchi");
		input.setNome("alberto");
		
		idS.add(socioS.createSocio(input));
		
		input = new SocioDTO();
		input.setcFiscale("546378922");
		input.setCognome("Vianello");
		input.setNome("Gino");
		
		idS.add(socioS.createSocio(input));
		log.debug("After create");
		
	}
	
	private void certificatoProcess() {
		try {
			CertificatoDTO certif = new CertificatoDTO();
			certif.setDataCertificato("12/4/2022");
			certif.setTipo("normale");
			certif.setSocioId(idS.get(0));
			idC.add(certifS.create(certif));
			
			certif = new CertificatoDTO();
			certif.setDataCertificato("12/6/2023");
			certif.setTipo("normale");
			certif.setSocioId(idS.get(1));
			idC.add(certifS.create(certif));
			
			certif = new CertificatoDTO();
			certif.setDataCertificato("30/2/2010");
			certif.setTipo("normale");
			certif.setSocioId(idS.get(2));
			idC.add(certifS.create(certif));
			
			
			
		} catch (AcademyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}	private void listSocio() {
		List<SocioDTO> lS = socioS.listAllSocio();
		lS.forEach(s->System.out.println("Lista dei bro: " + s.toString()));
	}
	
	private void listCertificato() {
		List<CertificatoDTO> lC = certifS.listCertificati();
		lC.forEach(s->System.out.println("Lista dei certifbro: " + s.toString()));
	}
	private void removeCertificato(Integer id){
		try {
			CertificatoDTO c = new CertificatoDTO();
			c.setId(id);
			certifS.remove(c);
		} catch (AcademyException e) {
			log.error("errore in rimozione certificato" + e.getMessage());
		}
		
	}
	
	private void removeSocio(Integer id) {
		try {
			SocioDTO s = new SocioDTO();
			s.setId(id);
			socioS.removeSocio(s);
		} catch (AcademyException e) {
			System.out.println("errore in rimozione certificato" + e.getMessage());
		}
	}
	
	private void updateSocio(Integer id, String nome, String cognome) {
		try {
			SocioDTO s = new SocioDTO();
			s.setId(id);
			s.setNome(nome);
			s.setCognome(cognome);
			socioS.updateSocio(s);
		} catch (AcademyException e) {
			System.out.println("errore in rimozione certificato" + e.getMessage());
		}
	}
	
	private void createAbbonamento(String data, Integer socioID) {
		try {
			AbbonamentoDTO inp = new AbbonamentoDTO();
			inp.setDataIscrizione(data);
			inp.setSocioID(socioID);
			abboS.create(inp);
		} catch (AcademyException e) {
			log.error("errore in creazione abbonamento: "+ socioID + " error " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}

