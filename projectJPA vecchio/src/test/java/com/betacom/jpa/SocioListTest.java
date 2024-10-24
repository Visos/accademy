package com.betacom.jpa;

import static org.junit.Assert.fail;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.service.interfaces.ISocioService;

@SpringBootTest
@Rollback(value=false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocioListTest {

	@Autowired
	ISocioService socioS;
	
	@Test
	@Order(1)
	public void listAllTest() {
		try {

			List<SocioViewDTO> lS = socioS.listSocio(null, null, null);
			Assertions.assertThat(lS.size()).isEqualTo(3);

		} catch (Exception e) {
			fail("Errore in list all" + e.getMessage());
		}
		
	}

	@Test
	@Order(2)
	public void listByIdTest() {
		try {
			List<SocioViewDTO> lS = socioS.listSocio(1, null, null);
			Assertions.assertThat(lS.size()).isEqualTo(1);
		} catch (Exception e) {
			fail("Errore in list by id" + e.getMessage());
		}
		
	}

	@Test
	@Order(3)
	public void listAllByCognomeTest() {
		try {
			List<SocioViewDTO> lS = socioS.listSocio(null, null, "Blue");
			Assertions.assertThat(lS.size()).isEqualTo(1);
		} catch (Exception e) {
			fail("Errore in list by cognome" + e.getMessage());
		}	
	}
}
