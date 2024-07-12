package com.betacom.jpa.service.intefaces;

import java.util.List;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.RequestBiciAmmortizzatori;

public interface IBiciService {

	
	void createAmmortizzatore(RequestBiciAmmortizzatori req) throws AcademyException;

	void create(BiciDTO biciI, VeicoloDTO veicolo) throws AcademyException;


	void removeBici(Integer id) throws AcademyException;

	List<BiciDTO> listAllBici();


}
