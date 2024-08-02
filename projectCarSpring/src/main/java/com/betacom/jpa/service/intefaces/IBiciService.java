package com.betacom.jpa.service.intefaces;

import java.util.List;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.BiciViewDto;
import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.TipoAmmortizzatore;
import com.betacom.jpa.request.RequestBiciAmmortizzatori;

public interface IBiciService {

	
	void createAmmortizzatore(RequestBiciAmmortizzatori req) throws AcademyException;



	void removeBici(Integer id) throws AcademyException;

	List<BiciViewDto> listAllBici();
	
	public List<BiciDTO> list();
	
	public List<TipoAmmortizzatoreDTO> transformAmmoInDto(List<TipoAmmortizzatore> resp);



}
