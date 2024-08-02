package com.betacom.jpa;

import static org.junit.Assert.fail;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.service.interfaces.ISocioService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SocioServiceTest {

	
	@Autowired
	ISocioService socS;
	
	@Test
	public void createSocioTest() {
		createsocioTest();
	}
	
	public void createsocioTest() {
		try {
			SocioDTO socio = new SocioDTO();
			socio.setNome("Paolo");
			socio.setCognome("Verdi");
			socio.setDataCerticicato("12/05/2024");
			socio.setcFiscale("bdbfbadvf");
			
			socS.createUpdateSocio(socio);
			
			Assertions.assertThat(socS.listAllSocio(1, null, null).get(0).getCognome()).isEqualTo("Verdi");
			
			socio = new SocioDTO();
			socio.setNome("Gino");
			socio.setCognome("Postino");
			socio.setDataCerticicato("12/06/2023");
			socio.setcFiscale("hhbfbadvf");
			
			socS.createUpdateSocio(socio);
			
			Assertions.assertThat(socS.listAllSocio(2, null, null).get(0).getCognome()).isEqualTo("Postino");
			
			socio = new SocioDTO();
			socio.setNome("Alberto");
			socio.setCognome("Rossi");
			socio.setDataCerticicato("12/15/2024");
			socio.setcFiscale("bdbfbappf");
			
			socS.createUpdateSocio(socio);
			
			Assertions.assertThat(socS.listAllSocio(3, null, null).get(0).getCognome()).isEqualTo("Rossi");
			
		} catch (AcademyException e) {
			fail("errore: " + e.getMessage());
		}
		
	}
}
