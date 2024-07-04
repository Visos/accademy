package com.betacom.jpa.service.interfaces;

import java.security.cert.Certificate;
import java.util.List;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Certificato;

public interface ICertificatoService {
	int create(CertificatoDTO cerificato) throws AcademyException;
	void remove (CertificatoDTO certificato) throws AcademyException;
	List<CertificatoDTO> listCertificati();

}
