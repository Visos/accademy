package com.betacom.jpa;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AbbonamentoServiceTest {

	@Autowired
	IAbbonamentoService abboS;
	
	@Test
	public void createAbboanmento() {
		
		try {
			
			AbbonamentoReq abb = new AbbonamentoReq();
			abb.setDataIscrizione("30/09/2022");
			abb.setSocioID(1);
			abboS.create(abb);
			
			
		} catch (Exception e) {
			fail("errore in abbonamento test: " + e.getMessage());
		}
		
	}
	
}
