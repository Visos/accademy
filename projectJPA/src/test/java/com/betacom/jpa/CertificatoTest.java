package com.betacom.jpa;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.jpa.request.CertificatoReq;
import com.betacom.jpa.service.interfaces.ICertificatoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CertificatoTest {
	
	@Autowired
	private ICertificatoService certifS;
	
	@Test
	public void createCerificatoTest() {
		try {
			
			CertificatoReq r = new CertificatoReq();
			r.setDataCertificato("01/01/2024");
			r.setTipo("normale");
			r.setSocioID(1);
			certifS.createUpate(r);
			
			r = new CertificatoReq();
			r.setDataCertificato("11/02/2024");
			r.setTipo("agonistico");
			r.setSocioID(2);
			certifS.createUpate(r);
			
			r = new CertificatoReq();
			r.setDataCertificato("21/03/2024");
			r.setTipo("normale");
			r.setSocioID(3);
			certifS.createUpate(r);
			
		} catch (Exception e) {
			fail("error in create certificato:" + e.getMessage());
		}
		
		
	}
}
