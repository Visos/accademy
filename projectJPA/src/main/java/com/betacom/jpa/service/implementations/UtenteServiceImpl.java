package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.UtenteDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Utente;
import com.betacom.jpa.repository.IUtenteRepository;
import com.betacom.jpa.request.UtenteReq;
import com.betacom.jpa.service.interfaces.IMessaggioService;
import com.betacom.jpa.service.interfaces.IUtenteService;
import com.betacom.jpa.util.Roles;

@Service
public class UtenteServiceImpl implements IUtenteService{

	@Autowired
	IUtenteRepository utenteR;
	
	@Autowired
	IMessaggioService msgS;
	
	@Override
	public void createUtente(UtenteReq req) throws AcademyException {
		Utente ut = new Utente();
		if (req.getId() != null) {
			Optional<Utente> u = utenteR.findById(req.getId());
			if (u.isEmpty()) {
				throw new AcademyException(msgS.getMessaggio("user-exist"));
			}
			ut = u.get();
		} else {
			Optional<Utente> u = utenteR.findByUserName(req.getUserName().trim());
			if (!u.isEmpty()) {
				throw new AcademyException(msgS.getMessaggio("user-exist"));
			}
		}
		ut.setUserName(req.getUserName());
		ut.setPwd(req.getPwd());
		ut.setRole(Roles.valueOf(req.getRole()));   
		
		utenteR.save(ut);
	}

	@Override
	public List<UtenteDTO> getAll() {
		List<Utente> r = utenteR.findAll();
		return r.stream()
				.map( s -> new UtenteDTO(
						s.getId(),
						s.getUserName(),
						s.getPwd(),
						s.getRole().toString())
						).collect(Collectors.toList());
	}

	@Override
	public UtenteDTO findUtente(String userName) throws AcademyException {
		Optional<Utente> u = utenteR.findByUserName(userName);
		if (u.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("user-exist"));
		}
		return new UtenteDTO(u.get().getId(),
				u.get().getUserName(),
				u.get().getPwd(), 
				u.get().getRole().toString());
	}

	@Override
	public UtenteDTO findUtenteById(Integer id) throws AcademyException {
		Optional<Utente> u = utenteR.findById(id);
		if (u.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("user-exist"));
		}
		return new UtenteDTO(u.get().getId(),
				u.get().getUserName(),
				u.get().getPwd(), 
				u.get().getRole().toString());
	}

	@Override
	public UtenteDTO signIn(String user, String pwd) throws AcademyException {
		Optional<Utente> u = utenteR.findByUserNameAndPwd(user.trim(), pwd.trim());
		if (u.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("invalid usr/pwd"));
		}
		return new UtenteDTO(u.get().getId(),
				u.get().getUserName(),
				u.get().getPwd(), 
				u.get().getRole().toString());
	}


	
}
