package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.CertificatoReq;

public interface ICertificatoService {
	
	void create(CertificatoReq certificato)throws AcademyException;
	
	List<CertificatoDTO> listCertificati();
	void remove(CertificatoReq certificato) throws AcademyException;
}
