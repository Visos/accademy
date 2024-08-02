package com.betacom.jpa;

import static org.junit.Assert.fail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.jpa.request.CertificatoReq;
import com.betacom.jpa.service.interfaces.ICertificatoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CertificatiTest {
	
	@Autowired
	private ICertificatoService certifS;
	
	@Test
	public void createCertificatoTest() {
		
		
		try {
			CertificatoReq r = new CertificatoReq();
			r.setDataCertificato("09/07/2021");
			r.setTipo("normale");
			r.setSocioID(1);
						
			certifS.create(r);
			
		} catch (Exception e) {
			fail("Errore create certificato");
		}

		
		
//		Assertions.assertThat();
	}


}
