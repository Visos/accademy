package com.betacom.jpa.service.intefaces;

import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.exception.AcademyException;

public interface ITipoAmmortizzatoreService{
	void createAmmortizzatore(TipoAmmortizzatoreDTO ammo);

	public void removeAmmortizzatore(Integer id) throws AcademyException;

}
