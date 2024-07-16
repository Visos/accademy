package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.request.AttivitaRequest;

public interface IAttivitaService {

	void create(AttivitaRequest att) throws AcademyException;

	List<AttivitaDTO> listAll(List<Attivita> resp);

	void createAttivitaAbbonamento(AttivitaRequest req) throws AcademyException;
}
