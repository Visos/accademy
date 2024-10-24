package com.betacom.jpa;

import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class AbbonamentoServiceTest {
	
	@Autowired
	private IAbbonamentoService abboS;
	
	@Test
	public void createAbbonamentoTest() {
		try {
			AbbonamentoReq r = new AbbonamentoReq();
			r.setDataIscrizione("01/07/2024");
			r.setSocioID(1);
			abboS.create(r);
		} catch (Exception e) {
			fail("error in create abbonamento:" + e.getMessage());
		}
		
		
	}

}
