package com.betacom.jpa;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.repository.IAttivitaRepository;

@DataJpaTest
@Rollback(value=false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttivitaRepositoryTest {
	@Autowired
	private IAttivitaRepository attivR;
	
	@Test
	@Order(1)
	public void saveAttivitaTest() {
		Attivita attiv = new Attivita();
		attiv.setDescrizione("Judo");
		
		attivR.save(attiv);
		Assertions.assertThat(attiv.getId()).isGreaterThan(0);
		
		attiv = new Attivita();
		attiv.setDescrizione("Karate");
		
		attivR.save(attiv);
		Assertions.assertThat(attiv.getId()).isGreaterThan(1);
	}
	
	@Test
	@Order(2)
	public void findAttivitaTest() {
		Optional<Attivita> a = attivR.findByDescrizione("Karate");
		
		Assertions.assertThat(a.isPresent()).isTrue();
	}
	
}
