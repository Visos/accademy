package com.betacom.jpa.service.intefaces;

import java.util.List;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;

public interface IveicoloService {

	void createVeicolo(VeicoloDTO veicolo, Integer id) throws AcademyException;
	void createBici(BiciDTO biciI, VeicoloDTO veicolo) throws AcademyException;
	void createMacchina(MacchinaDTO macchina, VeicoloDTO veicolo) throws AcademyException;
	void createMoto(MotoDTO motoI, VeicoloDTO veicolo) throws AcademyException;


	void removeVeicolo(Integer id) throws AcademyException;
	List<VeicoloDTO> listAll();

}
