package com.betacom.jpa.service.intefaces;

import java.util.List;

import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;

public interface IMotoService {

	void createMoto(MotoDTO motoI, VeicoloDTO veicolo) throws AcademyException;

	void removeMoto(Integer id) throws AcademyException;

	List<MotoDTO> listAllMoto();


}
