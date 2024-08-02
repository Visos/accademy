package com.betacom.jpa;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({SocioServiceTest.class,
				AttivitaServiceTest.class,
				CertificatiTest.class, 
				AbbonamentoServiceTest.class
				})
public class TestSuite {
	

}
