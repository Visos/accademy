package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.TipoColoreDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.TipoColore;
import com.betacom.jpa.pojo.Veicolo;
import com.betacom.jpa.repository.ITipoColoreRepository;
import com.betacom.jpa.repository.IVeicoloRepository;
import com.betacom.jpa.service.intefaces.ITipoColoreService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@Service
public class TipoColoreService implements ITipoColoreService{

	@Autowired
	ITipoColoreRepository colR;
	
	@Autowired
	IVeicoloRepository veiR;
	
	@Override
	public void createTipoColore(TipoColoreDTO colore){
		
		TipoColore colo = new TipoColore();
		colo.setCode(colore.getCode());
		colo.setDescrizione(colore.getDescrizione());
		
		colR.save(colo);
		
	}
	
	//public List<TipoColor> transformInList(List)

}
