package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.AttivitaReq;

public interface IAttivitaService {
	void create(AttivitaReq att) throws AcademyException ;
	
	void createAttivitaAbbonamento(AttivitaReq req) throws AcademyException;
	void removeAttivitaAbbonamento(AttivitaReq req) throws AcademyException;
	List<SocioDTO> removeAttivita(AttivitaReq req) throws AcademyException;
	
	List<AttivitaDTO> listAttivitaNonAbbonamento(Integer id) throws AcademyException; 
	List<AttivitaDTO> listAll();
	AttivitaViewDTO list(Integer id) throws AcademyException;
	List<AttivitaDTO> listByAbbonamento(Integer id) throws AcademyException;

	
	
}
