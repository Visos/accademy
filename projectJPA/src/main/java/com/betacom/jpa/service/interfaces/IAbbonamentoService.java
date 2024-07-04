package com.betacom.jpa.service.interfaces;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.exception.AcademyException;

public interface IAbbonamentoService {
	Integer create(AbbonamentoDTO abbonamento) throws AcademyException;

}
