package com.betacom.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTet {
	
	@Autowired
	IEmployeeRepository repoE;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveEmployee() {
		Employee e = new Employee();
		
		e.setCognome("Rossi");
		e.setNome("Paolo");
		e.setEmail("poaloverdi@gmail.com");
		
		repoE.save(e);
		
		Assertions.assertThat(e.getId()).isGreaterThan(0);
	
	}
	
	@Test
	@Order(2)

	public void getemployeeTest() {
		
		Employee e = repoE.findById(1).get();
		
		Assertions.assertThat(e.getId()).isEqualTo(1);
	}

}
