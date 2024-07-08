package com.betacom.jpa.service.implementations;

import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.pojo.Macchina;
import com.betacom.jpa.service.intefaces.IMacchinaService;

public class MacchinaServiceImpl implements IMacchinaService{

	@Override
	public void createMacchina(MacchinaDTO macchina) {
		Macchina mac = new Macchina();
	}



}
