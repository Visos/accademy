package com.betacom.jpa.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.pojo.TipoAmmortizzatore;
import com.betacom.jpa.repository.ITipoAmmortizzatoreRepository;
import com.betacom.jpa.service.intefaces.ITipoAmmortizzatoreService;

@Service
public class TipoAmmortizzatoreService implements ITipoAmmortizzatoreService{
	
	@Autowired
	ITipoAmmortizzatoreRepository ammoR;

	@Override
	public void createAmmortizzatore(TipoAmmortizzatoreDTO ammo) {
		TipoAmmortizzatore ammortizzator = new TipoAmmortizzatore();
		ammortizzator.setDescrizione(ammo.getDescrizione());
		ammortizzator.setBiciclette(ammo.get);
		
	}
}
