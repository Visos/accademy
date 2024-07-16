package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.repository.IAbbonamentoRepository;
import com.betacom.jpa.repository.IAttivitaRepository;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.request.AttivitaRequest;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggeService;

@Service
public class AttivitaImp implements IAttivitaService{

	@Autowired
	IAttivitaRepository attR;
	
	@Autowired
	IMessaggeService msgS;
	
	@Autowired
	IAbbonamentoRepository abboR;
	
	@Override
	public void create(AttivitaRequest req) throws AcademyException{
		
		Optional<Attivita> a = attR.findByDescrizione(req.getDescrizione().trim());
		if(a.isPresent())
			throw new AcademyException(msgS.getMessaggio("attiv-exist"));
		
		Attivita attivita = new Attivita();
		attivita.setDescrizione(req.getDescrizione());
		attR.save(attivita);

	}
	
	
	@Override
	public List<AttivitaDTO> listAll(List<Attivita> resp){
		List<Attivita> a = attR.findAll();
		return transformAttInDto(a);
	}
	
	private List<AttivitaDTO> transformAttInDto(List<Attivita> resp){
		return resp.stream()
				.map(s -> new AttivitaDTO(
						s.getId(),
						s.getDescrizione()
						)).collect(Collectors.toList());
	}
	
	@Override
	public void createAttivitaAbbonamento(AttivitaRequest req) throws AcademyException{
		Optional<Abbonamento> abb = abboR.findById(req.getAbbonamentoId());
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
		
		
		for (String attivita:req.getAttivita()) {
			Optional<Attivita> myAtt = attR.findByDescrizione(attivita.trim());
			if (myAtt.isEmpty())
				throw new AcademyException(msgS.getMessaggio("attiv-ntfnd" + attivita));
			if (existAttivita(abb.get().getAttivita(), attivita.trim()))
				throw new AcademyException(msgS.getMessaggio("attiv-exist-abb" + attivita));
			abb.get().getAttivita().add(myAtt.get());
		}
		abboR.save(abb.get());
	}
	
	private boolean existAttivita (List<Attivita> att, String search) {
		return att.stream()
				.map(Attivita::getDescrizione)
				.anyMatch(descrizione -> descrizione.equalsIgnoreCase(search));
	    }
	
	

	
}
