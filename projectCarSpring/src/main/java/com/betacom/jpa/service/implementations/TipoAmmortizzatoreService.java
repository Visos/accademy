package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Bici;
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
		ammortizzator.setId(ammo.getId());
		ammortizzator.setDescrizione(ammo.getDescrizione());
		ammoR.save(ammortizzator);
	}
	
	public List<TipoAmmortizzatoreDTO> transformInListDTO(List<TipoAmmortizzatore> resp ) {
		return resp.stream()
		.map(s -> new TipoAmmortizzatoreDTO(
				
				
				))
		.collect(Collectors.toList());
	}
	
	@Override
	public void removeAmmortizzatore(Integer id) throws AcademyException {
		Optional<TipoAmmortizzatore> ammortizator = ammoR.findById(id);
		if(ammortizator.isEmpty())
			throw new AcademyException("ammortizzatore sconosciuto");
		
		if(ammortizator.get().getBiciclette().size() >0) {
			throw new AcademyException("impossibile eliminare ammortizzatore, in uso su delle bici");
		}
			
		ammoR.delete(ammortizator.get());
			}
}
