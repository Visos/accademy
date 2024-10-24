package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.betacom.jpa.dto.PersoneDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Persone;
import com.betacom.jpa.repository.IPersoneRepository;
import com.betacom.jpa.request.PersonaReq;
import com.betacom.jpa.service.interfaces.IPersoneService;

public class PersoneServiceImpl implements IPersoneService{
	
	@Autowired
	IPersoneRepository perR;

	@Override
	public void create(PersonaReq req) throws AcademyException {
		Optional<Persone> p = perR.findByCognomeandNome(req.getCognome(), req.getCognome());
	    if (!p.isEmpty()) {
	        throw new AcademyException("Utente già creato");
	    }
	    Persone per = new Persone();
	    per.setCognome(req.getCognome());
	    per.setNome(req.getNome());
	    per.setEmail(req.getEmail());
	    per.setColor(req.getColor());
	    perR.save(per);
	}

	@Override
	public void update(PersonaReq req) throws AcademyException {
	    Optional<Persone> p = perR.findById(req.getId());
	    if (p.isEmpty()) {
	        throw new AcademyException("Utente non trovato");
	    }
	    Persone per = p.get();
	    per.setCognome(req.getCognome());
	    per.setNome(req.getNome());
	    per.setEmail(req.getEmail());
	    per.setColor(req.getColor());
	    perR.save(per);
	}

	@Override
	public void delete(PersonaReq req) throws AcademyException {
	    Optional<Persone> p = perR.findById(req.getId());
	    if (p.isEmpty()) {
	        throw new AcademyException("Utente non trovato");
	    }
	    perR.delete(p.get());
	}

	@Override
	public List<PersoneDTO> list() {
	    List<Persone> p = perR.findAll();
	    return p.stream()
	            .map(s -> new PersoneDTO(s.getId(), s.getCognome(), s.getNome(), s.getEmail(), s.getColor()))
	            .collect(Collectors.toList());
	}

	@Override
	public PersoneDTO getPersona(PersonaReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
