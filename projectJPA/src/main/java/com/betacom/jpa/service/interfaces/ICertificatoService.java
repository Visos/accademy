package com.betacom.jpa.service.interfaces;

import java.util.List;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.request.CertificatoReq;

public interface ICertificatoService {
	
	void createUpate(CertificatoReq certificato)throws AcademyException;
	void remove(CertificatoReq certificato)throws AcademyException;
	
	List<CertificatoDTO> listCertificati();
}
