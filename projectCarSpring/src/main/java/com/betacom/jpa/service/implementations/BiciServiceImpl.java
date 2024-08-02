package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.BiciViewDto;
import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Bici;
import com.betacom.jpa.pojo.Moto;
import com.betacom.jpa.pojo.TipoAmmortizzatore;
import com.betacom.jpa.pojo.Veicolo;
import com.betacom.jpa.repository.IBiciRepository;
import com.betacom.jpa.repository.ITipoAmmortizzatoreRepository;
import com.betacom.jpa.repository.IVeicoloRepository;
import com.betacom.jpa.request.RequestBiciAmmortizzatori;
import com.betacom.jpa.service.intefaces.IBiciService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@Service
public class BiciServiceImpl implements IBiciService{

	@Autowired
	IBiciRepository biciR;
	
	@Autowired
	ITipoAmmortizzatoreRepository ammoR;
	

	@Autowired
	IVeicoloRepository vecR;
	
	public static Logger log = LoggerFactory.getLogger(BiciServiceImpl.class);

	
	@Transactional(rollbackFor = Exception.class)


	@Override
	public void createAmmortizzatore(RequestBiciAmmortizzatori req) throws AcademyException {
		Optional<Bici> bici = biciR.findById(req.getBiciId());
		if(bici.isEmpty()) {
			throw new AcademyException("bici sconosciuto");
		}
		for(String ammo: req.getAmmortizzatori()) {
			Optional<TipoAmmortizzatore> myAmmo = ammoR.findByDescrizione(ammo.trim());
			if(myAmmo.isEmpty())
				throw new AcademyException("Ammortizzaore" + ammo + " non trovato");
			bici.get().getSospensioni().add(myAmmo.get());
		}
		biciR.save(bici.get());
	}
	
	private boolean existAmmortizzatore (List<TipoAmmortizzatore> list, String search) {
		return list.stream()
				.map(TipoAmmortizzatore::getDescrizione)
				.anyMatch(descrizione -> descrizione.equalsIgnoreCase(search));
	    }
	
	@Override
	public void removeBici(Integer id) throws AcademyException {
		Optional<Veicolo> veicolo = vecR.findById(id);
		if(veicolo.isEmpty())
			throw new AcademyException("veicolo sconosciuto");
		
		Integer idBici = vecR.findById(id).get().getBici().getId();
		Optional<Bici> bici = biciR.findById(idBici);
		if(bici.isEmpty())
			throw new AcademyException("bici sconosciuta");
		
		if(bici.get().getVeicolo() != null) {
			vecR.delete(bici.get().getVeicolo());
			log.debug("bici cancellata cancellato");
		}
		
		biciR.delete(bici.get());		
		vecR.delete(veicolo.get());
	}

	@Override
	public List<BiciViewDto> listAllBici() {
		List<Bici> resp = biciR.findAll();
		return transformListInViewDTO(resp);
	}
	
	@Override
	public List<BiciDTO> list() {
		List<Bici> resp = biciR.findAll();
		return transformListInDTO(resp);
	}

	private List<BiciDTO> transformListInDTO(List<Bici> resp) {
		return resp.stream()
				.map(s-> new BiciDTO(
						s.getId(),
						s.getTipoUso(),
						s.getPieghevole(),
						s.getVeicolo().getId(),
						transformAmmoInDto(s.getSospensioni())
						)).collect(Collectors.toList());
	}
	
	private List<BiciViewDto> transformListInViewDTO(List<Bici> resp) {
		return resp.stream()
				.map(s-> new BiciViewDto(
						s.getId(),
						s.getTipoUso(),
						s.getPieghevole(),
						transformAmmoInDto(s.getSospensioni()),
						s.getVeicolo().getId(),
						s.getVeicolo().getTipoAlimentazione().getDescrizione(),
						s.getVeicolo().getColore().getDescrizione(),
						s.getVeicolo().getTipoVeicolo().getDescrizione(),
						s.getVeicolo().getNumeroRuote(),
						s.getVeicolo().getnPosti(),
						s.getVeicolo().getMarca().getDescrizione()
						)).collect(Collectors.toList());
	}
	
	@Override
	public List<TipoAmmortizzatoreDTO> transformAmmoInDto(List<TipoAmmortizzatore> resp){
		return resp.stream()
				.map(s-> new TipoAmmortizzatoreDTO(
						s.getId(),
						s.getDescrizione(),
						null
						
						)).collect(Collectors.toList());
	}
	

}
