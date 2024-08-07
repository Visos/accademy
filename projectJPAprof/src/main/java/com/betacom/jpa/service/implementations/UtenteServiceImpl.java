package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.UtenteDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Utente;
import com.betacom.jpa.repository.IMessaggioRepository;
import com.betacom.jpa.repository.IUtenteRepository;
import com.betacom.jpa.request.UtenteReq;
import com.betacom.jpa.service.interfaces.IMessaggeService;
import com.betacom.jpa.service.interfaces.IUtenteService;
import com.betacom.jpa.util.Roles;

@Service
public class UtenteServiceImpl implements IUtenteService{

	@Autowired
	IUtenteRepository utenteR;
	
	@Autowired
	IMessaggeService msgS;
	
	@Override
	public void createUtente(UtenteReq req) throws AcademyException {
		Optional<Utente> u = utenteR.findByUserName(req.getUsername().trim());
		if(u.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("user-exist"));
		}
		Utente ut = new Utente();
		ut.setUsername(u.get().getUsername());
		ut.setPwd(u.get().getPwd());
		ut.setRole(Roles.valueOf(req.getRole()));
		
		utenteR.save(ut);
	}

	@Override
	public List<UtenteDTO> getAll() {
		List<Utente> r = utenteR.findAll();
		return r.stream()
				.map(s -> new UtenteDTO(
						s.getId(),
						s.getUsername(),
						s.getPwd(),
						s.getRole().toString()
						)).collect(Collectors.toList());
	}

}
