package com.betacom.jpa;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({SocioServiceTest.class, 
				CertificatoTest.class,
				AbbonamentoServiceTest.class,
				AttivitaServiceTest.class,
				SocioListTest.class, 
				AbbonamentoListTest.class})
public class TestSuite {

}
