package com.betacom.jpa.service.intefaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.TipoAlimentazioneDTO;
import com.betacom.jpa.pojo.TipoAlimentazione;
import com.betacom.jpa.repository.ITipoAlimRepository;

@Service
public class TipoAlimServiceImpl implements ITipoAlimentazioneService{
	
	@Autowired
	ITipoAlimRepository alimR;

	@Override
	public void createAlimentazione(TipoAlimentazioneDTO alim) {
		TipoAlimentazione alimentazione = new TipoAlimentazione();
		alimentazione.setCode(alim.getCode());
		alimentazione.setDescrizione(alim.getDescrizione());
		alimR.save(alimentazione);
	}

}
