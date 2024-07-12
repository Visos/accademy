package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Socio;

public interface ISocioService {
	void createSocio(SocioDTO socio) throws AcademyException;
	List<SocioViewDTO> listAllSocio();
	List<SocioDTO> serachCognome(String cognome);
	List<SocioDTO> serachCognomi(List<String> cognomi);
	List<SocioDTO> serachCognomiLike(String patter);
	List<SocioDTO> serachByAttivita(String patter);

	void removeSocio(SocioDTO socio) throws AcademyException;
	void updateSocio(SocioDTO s)throws AcademyException;
}
