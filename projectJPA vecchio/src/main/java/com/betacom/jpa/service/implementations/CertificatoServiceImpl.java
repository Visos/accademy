package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Certificato;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.repository.ICertificatoRepository;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.request.CertificatoReq;
import com.betacom.jpa.service.interfaces.ICertificatoService;
import com.betacom.jpa.service.interfaces.IMessaggioService;



@Service
public class CertificatoServiceImpl implements ICertificatoService{

	@Autowired
	private ICertificatoRepository certifR;
	
	@Autowired
	private ISocioRepository socioR;
	
	@Autowired
	IMessaggioService msgS;
	
	public static Logger log = LoggerFactory.getLogger(CertificatoServiceImpl.class);
	@Override
	public void createUpate(CertificatoReq certificato) throws AcademyException {
		log.debug("Begin create :" + certificato.getDataCertificato());
		
		Optional<Socio>  socio = socioR .findById(certificato.getSocioID());
		if (socio.isEmpty())
			throw new AcademyException(msgS.getMessaggio("socio-ntfnd") + certificato.getDataCertificato());
		
		Certificato certif = null;
		if (socio.get().getCertificato() != null)
			certif = socio.get().getCertificato();
		else
			certif = new Certificato();
		
		if ((!"normale".equalsIgnoreCase(certificato.getTipo())) && (!"agonistico".equalsIgnoreCase(certificato.getTipo())) )
			throw new AcademyException(msgS.getMessaggio("certificato-tipo-non-valido"));
		log.debug("Creazione");
		certif.setTipo((certificato.getTipo().equalsIgnoreCase("normale") ? false : true ));
		certif.setDataCertificato(certificato.getDataCertificato());
		certif.setSocio(socio.get());
		try {
			certifR.save(certif);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("certificato-generic") + e.getMessage());
		}
		
	}
	
	
	
	@Override
	public List<CertificatoDTO> listCertificati() {
		List<Certificato> resp = certifR.findAll();
		
		return resp.stream()
				.map(s -> new CertificatoDTO(
						s.getId(),
						(s.getTipo()?  "Agonistico" : "Normale"),
						s.getDataCertificato(),
						s.getSocio().getId(),
						s.getSocio().getCognome(),
						s.getSocio().getNome(),
						s.getSocio().getcFiscale()
						)) 
				.collect(Collectors.toList());
	}
	@Override
	public void remove(CertificatoReq certificato) throws AcademyException {
		Optional<Certificato> certif = certifR.findById(certificato.getId());
		if (certif.isEmpty())
			throw new AcademyException(msgS.getMessaggio("certif-ntfnd"));
		
		certifR.delete(certif.get());
		
	}

}
