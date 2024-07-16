package com.betacom.jpa.process;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.ICertificatoService;
import com.betacom.jpa.service.interfaces.ISocioService;

@Component
public class ProcessTestJPA {

	@Autowired
	private ISocioService socioS;
	
	@Autowired
	private ICertificatoService certifS;
	
	@Autowired
	private IAbbonamentoService abboS;

	@Autowired
	private IAttivitaService attS;

	
	public static Logger log = LoggerFactory.getLogger(ProcessTestJPA.class);

	private List<Integer> idS = new ArrayList<Integer>();
	List<Integer> idC = new ArrayList<Integer>();
	List<Integer> idA = new ArrayList<Integer>();

	public void execute() {
		
//		socioProcess();
//		certificatoProcess();
//		createAbbornamento("01/01/2024", idS.get(0));
//		createAbbornamento("05/05/2024", idS.get(0));
//		
//		createAbbornamento("01/01/2024", idS.get(1));
//		createAbbornamento("05/05/2024", idS.get(2));
//
//		log.debug("Abbonamenti creati:" + idA.size());
		
		
//		createAbboAtt(idA.get(0), new String [] {"Yoga", "Karate"});
//		createAbboAtt(5, new String [] {"Karate"});
//		removeAbboAtt(5, new String [] {"Karate"});
		
//		createAttivita("Yoga");
//		createAttivita("Zumba");
//		createAttivita("Karate");
//		createAttivita("Nuoto");
//		createAttivita("Judo");

//		
//		listSocio();
		log.debug("extract cognome with o");
		listSocioLike("o");
//		listCetificati();
		listSocioAttivita("Yoga");
		
		
//		log.debug("******** Find by cognome ********************");
//		List<SocioDTO> sC = socioS.searchCognome("Verde");
//		sC.forEach(sc -> log.info(sc.toString()));
//		List<String> p = new ArrayList<String>();
//		p.add("Rossi");
//		p.add("Verde");
//		
//		List<SocioDTO> sCI = socioS.searchCognomi(p);
//		sCI.forEach(s -> log.info(s.toString()));		
// 		removeCertificato(idC.get(0));
//
// 		removeSocio(idS.get(1));
// 		listSocio();
// 		listCetificati();
// 			
//		try {
// 
//			SocioDTO input = new SocioDTO();
//			input.setcFiscale("ZZZZZZZZZ");
//			input.setCognome("Update");
//			input.setNome("Upd");
//			input.setId(idS.get(3));
//			socioS.createUpdateSocio(input);
//		} catch (AcademyException e) {
//			log.error("Errore in aggiornamente socio:" + e.getMessage());
//		}
// 		listSocio();

 		
	}
	
//	private void certificatoProcess() {
//		try {
//			
//			CertificatoDTO certif = new CertificatoDTO();
//			certif.setDataCertificato("12/04/2024");
//			certif.setTipo("normale");
//			certif.setSocioID(idS.get(0));
//			idC.add(certifS.create(certif));
//			
//			certif = new CertificatoDTO();
//			certif.setDataCertificato("01/05/2024");
//			certif.setTipo("normale");
//			certif.setSocioID(idS.get(1));
//			idC.add(certifS.create(certif));
//
//			certif = new CertificatoDTO();
//			certif.setDataCertificato("10/05/2024");
//			certif.setTipo("normale");
//			certif.setSocioID(idS.get(2));
//			idC.add(certifS.create(certif));
//
//			
//		} catch (AcademyException e) {
//			log.error("errore in creazione certificata :" + e.getMessage());
//		}
//
//	}
	
	private void listSocioLike(String pattern) {
		log.info("List Socio Like ******");
		List<SocioDTO> lS = socioS.searchCognomiLike(pattern);
		lS.forEach(s -> log.info(s.toString()));

	}

	
	private void listSocioAttivita(String attivita) {
		log.info("List Socio Attivita ******");
		List<SocioDTO> lS = socioS.searchByAttivia(attivita);
		lS.forEach(s -> log.info(s.toString()));

	}


	private void listCetificati() {
		log.info("List Certificati ******");
		List<CertificatoDTO> lC = certifS.listCertificati();
		lC.forEach(c -> log.info(c.toString()));
		
	}
	
//	private void removeCertificato(Integer id) {
//		try {
//			CertificatoDTO p = new CertificatoDTO();
//			p.setId(id);
//			certifS.remove(p);
//	
//		} catch (AcademyException e) {
//			log.error("errore in rimozione certificata :" + e.getMessage());
//		}
//	}
	
	private void removeSocio(Integer id) {
		try {
			SocioDTO p = new SocioDTO();
			p.setId(id);
			socioS.removeSocio(p);
	
		} catch (AcademyException e) {
			log.error("errore in rimozione certificata :" + e.getMessage());
		}
	}
//	private void createAbbornamento(String data, Integer socioId) {
//		try {
//	
//			AbbonamentoDTO inp = new AbbonamentoDTO();
//			inp.setDataIscrizione(data);
//			inp.setSocioID(socioId);
//			idA.add(abboS.create(inp));
//		} catch (AcademyException e) {
//			log.error("errore in create abbornamento:" + socioId + " error:" + e.getMessage()) ;
//		}
//		
//	}
	
//	private void createAttivita(String attivita) {
//	        attS.create(new AttivitaDTO(attivita));
//	}
//	
//	private void createAbboAtt(Integer idAbb, String[] attivita) {
//		AbbonamentoAttivitaReq req = new AbbonamentoAttivitaReq(idAbb, attivita);
//		try {
//			abboS.createAttivita(req);
//		} catch (AcademyException e) {
//			log.error("Errore creazione attivita dentro abbonamento :" + e.getMessage());
//		}
//		
//		
//	}
	
//	private void removeAbboAtt(Integer idAbb, String[] attivita) {
//		AbbonamentoAttivitaReq req = new AbbonamentoAttivitaReq(idAbb, attivita);
//		try {
//			abboS.removeAttivita(req);;
//		} catch (AcademyException e) {
//			log.error("Errore remove attivita dentro abbonamento :" + e.getMessage());
//		}
//	}

}
