package com.betacom.jpa;

import static org.junit.jupiter.api.Assertions.fail;

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
	private IAbbonamentoService abboS;
	
	@Test
	public void createAbbonamentoTest() {
		try {
			AbbonamentoReq r = new AbbonamentoReq();
			r.setDataIscrizione("01/07/2024");
			r.setSocioID(1);
			abboS.create(r);
			
			r = new AbbonamentoReq();
			r.setDataIscrizione("11/08/2024");
			r.setSocioID(2);
			abboS.create(r);
			
			r = new AbbonamentoReq();
			r.setDataIscrizione("21/09/2024");
			r.setSocioID(3);
			abboS.create(r);
			
		} catch (Exception e) {
			fail("error in create abbonamento:" + e.getMessage());
		}
		
		
	}

}
