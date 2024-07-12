package com.betacom.jpa.service.intefaces;

import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;

public interface IveicoloService {

	void createVeicolo(VeicoloDTO veicolo, Integer id) throws AcademyException;
	void removeVeicolo(Integer id) throws AcademyException;

}
