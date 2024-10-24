package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.PersoneDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Persone;
import com.betacom.jpa.repository.IPersoneRepository;
import com.betacom.jpa.request.PersoneReq;
import com.betacom.jpa.service.interfaces.IPersoneService;

@Service
public class PersoneServiceImpl implements IPersoneService{

	@Autowired
	IPersoneRepository perR;
	
	@Override
	public void create(PersoneReq req) throws AcademyException {
		Optional<Persone> p = perR.findByCognomeAndNome(req.getCognome(), req.getNome());
		if (!p.isEmpty())
			throw new AcademyException("Utente già creato");
		Persone per = new Persone();
		per.setCognome(req.getCognome());
		per.setNome(req.getNome());
		per.setEmail(req.getEmail());
		per.setColor(req.getColor());
		perR.save(per);
		
	}

	@Override
	public void update(PersoneReq req) throws AcademyException {
		Optional<Persone> p = perR.findById(req.getId());
		if (p.isEmpty())
			throw new AcademyException("Utente non trovato");
		Persone per = p.get();
		per.setCognome(req.getCognome());
		per.setNome(req.getNome());
		per.setEmail(req.getEmail());
		per.setColor(req.getColor());
		perR.save(per);
		
	}

	@Override
	public void delete(PersoneReq req) throws AcademyException {
		Optional<Persone> p = perR.findById(req.getId());
		if (p.isEmpty())
			throw new AcademyException("Utente non trovato");

		perR.delete(p.get());
	}

	@Override
	public List<PersoneDTO> list() {
		List<Persone> p = perR.findAll(); 
		return p.stream()
				.map(s -> new PersoneDTO(
						s.getId(),
						s.getNome(),
						s.getCognome(),
						s.getEmail(),
						s.getColor()
						)).toList();
	}

	@Override
	public PersoneDTO getPersona(Integer id) throws AcademyException {
		Optional<Persone> p = perR.findById(id);
		if (p.isEmpty())
			throw new AcademyException("Utente non trovato");
		return new PersoneDTO(
				p.get().getId(),
				p.get().getNome(),
				p.get().getCognome(),
				p.get().getEmail(),
				p.get().getColor()
				);
	}

}
