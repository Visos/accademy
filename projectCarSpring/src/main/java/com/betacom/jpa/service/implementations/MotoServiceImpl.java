package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.MotoViewDto;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Moto;
import com.betacom.jpa.pojo.Veicolo;
import com.betacom.jpa.repository.IMotoRepository;
import com.betacom.jpa.repository.IVeicoloRepository;
import com.betacom.jpa.service.intefaces.IMotoService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@Transactional(rollbackFor = Exception.class)
@Service
public class MotoServiceImpl implements IMotoService {
	
	@Autowired
	IMotoRepository motoR;
	
	@Autowired
	IVeicoloRepository vecR;
	
	@Autowired
	IveicoloService vecS;
	
	public static Logger log = LoggerFactory.getLogger(MotoServiceImpl.class);


	
	@Override
	public void removeMoto(Integer id) throws AcademyException {
		Optional<Veicolo> veicolo = vecR.findById(id);
		if(veicolo.isEmpty())
			throw new AcademyException("veicolo sconosciuto");
		
		Integer idMoto = vecR.findById(id).get().getMoto().getId();
		Optional<Moto> moto = motoR.findById(idMoto);
		if(moto.isEmpty())
			throw new AcademyException("moto sconosciuta");
		
		if(moto.get().getVeicolo() != null) {
			vecR.delete(moto.get().getVeicolo());
			log.debug("moto cancellata cancellato");
		}
		
		motoR.delete(moto.get());		
		vecR.delete(veicolo.get());
	}

	@Override
	public List<MotoViewDto> listAllMoto() {
		List<Moto> resp = motoR.findAll();
		
		return transformInListViewDTO(resp);
	}

	private List<MotoDTO> transformInListDTO(List<Moto> resp) {
		return resp.stream()
				.map(s-> new MotoDTO(
					s.getId(),
					s.getTarga(),
					s.getCc(),
					s.getVeicolo().getId()
						)).collect(Collectors.toList());
	}
	
	private List<MotoViewDto> transformInListViewDTO(List<Moto> resp) {
		return resp.stream()
				.map(s-> new MotoViewDto(
					s.getId(),
					s.getTarga(),
					s.getCc(),
					s.getVeicolo().getId(),
					s.getVeicolo().getTipoAlimentazione().getDescrizione(),
					s.getVeicolo().getColore().getDescrizione(),
					s.getVeicolo().getTipoVeicolo().getDescrizione(),
					s.getVeicolo().getNumeroRuote(),
					s.getVeicolo().getnPosti(),
					s.getVeicolo().getMarca().getDescrizione()
						)).collect(Collectors.toList());
	}

}
