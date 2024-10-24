package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.PersoneDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.PersonaReq;

public interface IPersoneService {
	void create(PersonaReq req) throws AcademyException;
	void update(PersonaReq req) throws AcademyException;
	void delete(PersonaReq req) throws AcademyException;
	List<PersoneDTO> list();
	PersoneDTO getPersona(PersonaReq req);
	


	

}
