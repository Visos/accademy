package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AbbonamentoReq;

public interface IAbbonamentoService {
 
	Integer create(AbbonamentoReq abbo) throws AcademyException;
	void removeAbbonamento(Integer id) throws AcademyException;
	void forseRemoveAbbonamento(Integer id) throws AcademyException;
	List<AbbonamentoViewDTO> listAbbonamenti(Integer id) throws AcademyException;
	List<AbbonamentoViewDTO> listAbbonamentiBySocio(Integer id) throws AcademyException;
	
}
