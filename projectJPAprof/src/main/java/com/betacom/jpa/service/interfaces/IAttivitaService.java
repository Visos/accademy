package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.request.AttivitaRequest;

public interface IAttivitaService {

	void create(AttivitaRequest att) throws AcademyException;

	List<AttivitaDTO> listAll();

	void createAttivitaAbbonamento(AttivitaRequest req) throws AcademyException;
	
	void removeAttivitaAbbonamento(AttivitaRequest req) throws AcademyException;
	
	boolean removeAttivita(AttivitaRequest req) throws AcademyException;
	
	List<AbbonamentoDTO> getByDescrizioneAtt(String descrizione) throws AcademyException;

	List<AttivitaDTO> listAttivitaByAbboo(Integer id) throws AcademyException;

	List<AttivitaDTO> listAttivitaNonAbboo(Integer id) throws AcademyException;



}
