package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.aspectj.bridge.AbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.repository.IAbbonamentoRepository;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;

@Service
public class AbbonamentoService implements IAbbonamentoService{

	@Autowired
	IAbbonamentoRepository abboR;
	
	@Autowired
	ISocioRepository socioR;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoService.class);



	@Override
	public Integer create(AbbonamentoDTO abbo) throws AcademyException {
		Optional<Socio> soc = socioR.findById(abbo.getSocioID());
		if(soc.isEmpty())
			throw new AbortException();	
		Abbonamento abb = new Abbonamento();
		abb.setDataIscrizione(abbo.getDataIscrizione());
		abb.setSocio(soc.get());
		return abboR.save(abb).getId();
		
	}

}
