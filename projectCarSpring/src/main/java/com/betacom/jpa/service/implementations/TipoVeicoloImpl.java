package com.betacom.jpa.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.TipoVeicoloDTO;
import com.betacom.jpa.pojo.TipoVeicolo;
import com.betacom.jpa.repository.ITipoVeicoloRepository;
import com.betacom.jpa.service.intefaces.ITipoVeicoloService;

@Service
public class TipoVeicoloImpl implements ITipoVeicoloService{
	
	@Autowired
	ITipoVeicoloRepository tipoR;

	@Override
	public void createTipVeicolo(TipoVeicoloDTO tipoI) {
		TipoVeicolo tipo = new TipoVeicolo();
		tipo.setDescrizione(tipoI.getDescrizione());
		tipo.setId(tipoI.getId());
		
		tipoR.save(tipo);
		
	}

}
