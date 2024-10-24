package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.PersoneDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.PersoneReq;

public interface IPersoneService {
	
	void create(PersoneReq req) throws AcademyException;
	
	void update(PersoneReq req) throws AcademyException;
	
	void delete(PersoneReq req) throws AcademyException;

	List<PersoneDTO> list();
	
	PersoneDTO getPersona(Integer id) throws AcademyException;

}
