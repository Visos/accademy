package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.request.AbbonamentoReq;

public interface IAbbonamentoService {
 
	Integer create(AbbonamentoReq abbo) throws AcademyException;
	//void removeAttivita(AbbonamentoAttivitaReq req) throws AcademyException;
	List<AbbonamentoViewDTO> listAbbonamento(Integer id) throws AcademyException;
	List<AbbonamentoDTO> listInAbboDTO(List<Abbonamento> resp);
	List<AbbonamentoViewDTO> listAbbonamentiBySocio(Integer id) throws AcademyException;
	void removeAbbonamento(Integer id) throws AcademyException;


	
	
}
