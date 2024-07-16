package com.betacom.jpa.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.repository.IAttivitaRepository;
import com.betacom.jpa.service.interfaces.IAttivitaService;

@Service
public class AttivitaServiceImpl implements IAttivitaService{
	
	@Autowired
	IAttivitaRepository attR;

    @Override
    public void create(AttivitaDTO att) {
    	
    	
        Attivita attivita = new Attivita();
        attivita.setDescrizione(att.getDescrizione());
        attR.save(attivita);
    }

	@Override
	public void remove(String attivita) {
		// TODO Auto-generated method stub
		
	}

}
