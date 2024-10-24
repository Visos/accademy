package com.betacom.jpa.service.interfaces;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.UtenteReq;

import java.util.List;

import com.betacom.jpa.dto.UtenteDTO;

public interface IUtenteService {

	void createUtente(UtenteReq req ) throws AcademyException;
	List<UtenteDTO> getAll();
	public UtenteDTO findUtente(String userName) throws AcademyException;
	public UtenteDTO findUtenteById(Integer id) throws AcademyException;
	public UtenteDTO signIn(String user, String pwd) throws AcademyException;
}


