package com.betacom.jpa;

import static org.junit.Assert.fail;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AttivitaRequest;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.ISocioService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttivitaServiceTest {
	
	@Autowired
	private IAttivitaService attivS;
	
	@Autowired
	private ISocioService socS;
	
	private SocioServiceTest socT = new SocioServiceTest();
	
	@Test
	@Order(1)
	public void AttivitaServiceImplTest() throws Exception {
		
		try {
			Assertions.assertThat(socS.listAllSocio(2, null, null).get(0).getCognome()).isEqualTo("Postino");
						
			List<SocioViewDTO> lS = socS.listAllSocio(null, null, null);
			Assertions.assertThat(lS.size()).isGreaterThan(0);
			
			AttivitaRequest req = new AttivitaRequest();
			req.setDescrizione("Test");
			attivS.create(req);
			List<AttivitaDTO> lA = attivS.listAll();
			Assertions.assertThat(lA.size()).isGreaterThan(0);
		} catch (Exception e) {
			fail("Errore " + e.getMessage());
		}

		
	}
	
	@Test
	@Order(2)
	public void AttivitaServiceImplTest1() throws Exception {
		try {
			AttivitaRequest req = new AttivitaRequest();
			req.setDescrizione("Prova");
			attivS.create(req);
			List<AttivitaDTO> lA = attivS.listAll();
			Assertions.assertThat(lA.size()).isGreaterThan(1);
		} catch (Exception e) {
			fail("errore " + e.getMessage());
		}
		
	}
	
	@Test
	@Order(3)
	public void createAttivitaAbbonamneto() {

		try {
			AttivitaRequest req = new AttivitaRequest();
			req.setAttivita(new String[] {
					"Karate"
			});
			req.setAbbonamentoID(1);
			
//			AttivitaViewDTO a = attivS.list(2);
			
			
			attivS.create(req);
		} catch (AcademyException e) {
			System.out.println("errore attivita service: " + e.getMessage());
		}
		
		
	}
	
	//list all
	//remoe attivAbbonameto
	//remove attivita
	//list attivita specifica

	
}
