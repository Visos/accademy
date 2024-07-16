package com.betacom.jpa.service.interfaces;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoAttivitaRequest;

public interface IAbbonamentoService {
	Integer create(AbbonamentoDTO abbonamento) throws AcademyException;
	void createAttivita(AbbonamentoAttivitaRequest abbonamento) throws AcademyException;
	void removeAttivita(AbbonamentoAttivitaRequest req) throws AcademyException;

}
