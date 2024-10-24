package com.betacom.jpa;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.request.AttivitaReq;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.ISocioService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttivitaServiceTest {
	
	@Autowired
	private IAttivitaService attivS;
	
	@Autowired
	ISocioService socioS;
		
	@Test
	@Order(1)
	public void attivitaServiceImplTest() {
		try {
			
			Assertions.assertThat(socioS.listSocio(2, null, null).get(0).getCognome()).isEqualTo("Blue");
			
			AttivitaReq req = new AttivitaReq();
			req.setDescrizione("Judo");
			attivS.create(req);
			
			List<AttivitaDTO> lA = attivS.listAll();
			
			Assertions.assertThat(lA.size()).isGreaterThan(0);
	
		} catch (Exception e) {
			fail("error in esecuzione:" + e.getMessage());
		}
	}
	
	@Test
	@Order(2)
	public void attivitaServiceImplTest1(){
		try {
			AttivitaReq req = new AttivitaReq();
			req.setDescrizione("Karate");
			attivS.create(req);
			
			List<AttivitaDTO> lA = attivS.listAll();
			
			Assertions.assertThat(lA.size()).isGreaterThan(1);
	
		} catch (Exception e) {
			fail("error in esecuzione:" + e.getMessage());
		}
	}
	@Test
	@Order(3)
	public void createAttivitaAbbonamento() {
		try {
			AttivitaReq req = new AttivitaReq();
			req.setAttivita(new String []{"Karate"});
			req.setAbbonamentoID(1);
			attivS.createAttivitaAbbonamento(req);
			
			AttivitaViewDTO a = attivS.list(2);
			
			Assertions.assertThat(a.getAttivita().get(0).getCognome()).isEqualTo("Verdi");
	
		} catch (Exception e) {
			fail("error in createAttivitaAbbonamento:" + e.getMessage());
		}
	}

}
