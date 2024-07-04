package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;

public interface ISocioService {
	Integer createSocio(SocioDTO socio);
	List<SocioDTO> listAllSocio();
	List<SocioDTO> serachCognome(String cognome);
	List<SocioDTO> serachCognomi(List<String> cognomi);
	void removeSocio(SocioDTO socio) throws AcademyException;
	void updateSocio(SocioDTO s)throws AcademyException;
}
