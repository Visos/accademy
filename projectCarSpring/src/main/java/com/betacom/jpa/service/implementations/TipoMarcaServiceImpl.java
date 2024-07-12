package com.betacom.jpa.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.MarcaDTO;
import com.betacom.jpa.pojo.TipoMarca;
import com.betacom.jpa.repository.ITipoMarcaRepository;
import com.betacom.jpa.service.intefaces.ITipoMarcaService;

@Service
public class TipoMarcaServiceImpl implements ITipoMarcaService{
	
	@Autowired
	ITipoMarcaRepository marcaR;

	@Override
	public void createMarca(MarcaDTO marca) {
		TipoMarca tMar= new TipoMarca();
		tMar.setDescrizione(marca.getDescrizione());
		tMar.setId(marca.getId());
		
		marcaR.save(tMar);
		
	}

	
}
