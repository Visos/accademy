package com.betacom.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
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

import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AttivitaReq;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.ISocioService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttivitaServiceTest {
	
	@Autowired
	private IAttivitaService attivS;
	
	@Autowired
	ISocioService socioS;
		
	@Test
	@Order(1)
	public void attivitaServiceImplTest() {
		
			
		Assertions.assertThat(socioS.listSocio(2, null, null).get(0).getCognome()).isEqualTo("Blue");
		
		AttivitaReq req = new AttivitaReq();
		req.setDescrizione("Judo");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			attivS.create(req);
		});
		
		assertEquals("attiv-exist", exception.getMessage());
	}
	
	@Test
	@Order(2)
	public void attivitaServiceImplTest1(){
	
		AttivitaReq req = new AttivitaReq();
		req.setDescrizione("Karate");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			attivS.create(req);
		});
		
		assertEquals("attiv-exist", exception.getMessage());
	}

	@Test
	@Order(2)
	public void attivitaServiceImplTest2(){
		
		AttivitaReq req = new AttivitaReq();
		req.setDescrizione("Yoga");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			attivS.create(req);
		});
		
		assertEquals("attiv-exist", exception.getMessage());
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
			fail("Errore in creazione attivita abbonamento");
		}
	}

	@Test
	@Order(4)
	public void createAttivitaAbbonamento1() {
		
		try {
			AttivitaReq req = new AttivitaReq();
			req.setAttivita(new String []{"Judo", "Karate"});
			req.setAbbonamentoID(2);
			attivS.createAttivitaAbbonamento(req);

			AttivitaViewDTO a = attivS.list(1);
			Assertions.assertThat(a.getAttivita().get(0).getCognome()).isEqualTo("Blue");

			a = attivS.list(2);
			Assertions.assertThat(a.getAttivita().get(1).getCognome()).isEqualTo("Blue");

		} catch (Exception e) {
			fail("Errore in creazione attivita abbonamento");
		}
		
		
		
	}

	@Test
	@Order(5)
	public void createAttivitaAbbonamento2() {
		try {
			AttivitaReq req = new AttivitaReq();
			req.setAttivita(new String []{"Judo", "Karate", "Yoga"});
			req.setAbbonamentoID(3);

			attivS.createAttivitaAbbonamento(req);

			AttivitaViewDTO a = attivS.list(1);
			Assertions.assertThat(a.getAttivita().get(1).getCognome()).isEqualTo("Yellow");

			a = attivS.list(2);
			Assertions.assertThat(a.getAttivita().get(2).getCognome()).isEqualTo("Yellow");

			a = attivS.list(3);
			Assertions.assertThat(a.getAttivita().get(0).getCognome()).isEqualTo("Yellow");

		} catch (Exception e) {
			fail("Errore in creazione attivita abbonamento");
		}
	}

	@Test
	@Order(6)
	public void removeAttivitaAbbonamentoTest() {
		try {
			AttivitaReq req = new AttivitaReq();
			req.setAttivita(new String []{"Judo", "Karate", "Yoga"});
			req.setAbbonamentoID(3);
			attivS.removeAttivitaAbbonamento(req);

			List<SocioViewDTO> lS = socioS.listSocio(3, null, null);

			Assertions.assertThat(lS.get(0).getAbbonamenti().get(0).getAttivita().size()).isEqualTo(0);			
		} catch (Exception e) {
			fail("error in delete");
		}
	}

}
