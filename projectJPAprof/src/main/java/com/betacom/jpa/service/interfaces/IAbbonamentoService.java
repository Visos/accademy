package com.betacom.jpa.service.interfaces;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.request.AbbonamentoReq;

public interface IAbbonamentoService {
 
	Integer create(AbbonamentoReq abbo) throws AcademyException;
	//void removeAttivita(AbbonamentoAttivitaReq req) throws AcademyException;
	
	
}
