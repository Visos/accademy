package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.pojo.Veicolo;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Macchina;
import com.betacom.jpa.repository.IMacchinaRepository;
import com.betacom.jpa.repository.IVeicoloRepository;
import com.betacom.jpa.service.intefaces.IMacchinaService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@Transactional(rollbackFor = Exception.class)
@Service
public class MacchinaServiceImpl implements IMacchinaService{
	
	@Autowired
	IMacchinaRepository maccR;
	
	@Autowired
	IveicoloService vecS;
	
	@Autowired
	IVeicoloRepository vecR;
	
	public static Logger log = LoggerFactory.getLogger(MacchinaServiceImpl.class);

	@Override
	public void createMacchina(MacchinaDTO macchina, VeicoloDTO veicolo) throws AcademyException {
		Macchina mac = null;
		if(macchina.getId() != null) {
			Optional<Macchina> myMac = maccR.findById(macchina.getId());
			if(myMac.isEmpty())
				throw new AcademyException("macchina sconosciuta");
			mac = myMac.get();
		}else
			mac = new Macchina();
		if(macchina.getNumeroPorte()>7 || macchina.getNumeroPorte()<2) {
			throw new AcademyException("numero porte non valido");
		}
		mac.setNumeroPorte(macchina.getNumeroPorte());
		if(macchina.getNumerotarga().length()!=7) {
			throw new AcademyException("numero targa non valido");
		}
		mac.setNumerotarga(macchina.getNumerotarga());
		
				
		vecS.createVeicolo(veicolo, maccR.save(mac).getId());

		
		
	}
	@Override
	public void removeMacchina(Integer id) throws AcademyException {
		Optional<Veicolo> veicolo = vecR.findById(id);
		if(veicolo.isEmpty())
			throw new AcademyException("veicolo sconosciuto");
		
		Integer idMac = vecR.findById(id).get().getMacchina().getId();
		Optional<Macchina> mac = maccR.findById(idMac);
		if(mac.isEmpty())
			throw new AcademyException("macchina sconosciuta");
		
		if(mac.get().getVeicolo() != null) {
			vecR.delete(mac.get().getVeicolo());
			log.debug("macchina cancellata cancellato");
		}
		
		maccR.delete(mac.get());		
		vecR.delete(veicolo.get());
	}
	
	@Override
	public List<MacchinaDTO> listAllMacchine(){
		List<Macchina> rest = maccR.findAll();
		return transformListInDTO(rest);
	}

	public List<MacchinaDTO> transformListInDTO(List<Macchina> resp){
		return resp.stream()
				.map( s-> new MacchinaDTO(
						s.getId(),
						s.getNumeroPorte(),
						s.getNumerotarga(),
						s.getVeicolo()
						)).collect(Collectors.toList());
		
	}



}
