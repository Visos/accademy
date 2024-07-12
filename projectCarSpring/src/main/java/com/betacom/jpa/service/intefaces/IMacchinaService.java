package com.betacom.jpa.service.intefaces;

import java.util.List;

import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;

public interface IMacchinaService {
	void createMacchina(MacchinaDTO macchina, VeicoloDTO veicolo) throws AcademyException;
	void removeMacchina(Integer id) throws AcademyException;
	List<MacchinaDTO> listAllMacchine();


}
