package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.CertificatoDTO;
import com.betacom.jpa.pojo.Certificato;

import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.repository.IcertificatoRepository;
import com.betacom.jpa.service.interfaces.ICertificatoService;

@Service
public class CertificatoSeriviceImpl implements ICertificatoService{
	
	@Autowired
	private IcertificatoRepository certifR;
	
	@Autowired
	private ISocioRepository socioR;
	
	public static Logger log = LoggerFactory.getLogger(CertificatoSeriviceImpl.class);
	
	@Override
	public int create(CertificatoDTO certificato) throws AcademyException{
		
		log.debug("Begin create" + certificato.getSocioId());
		Optional<Socio> socio = socioR.findById(certificato.getSocioId());
		if (socio.isEmpty()) {
			throw new AcademyException("Socio sconosciuto");
		}
		
		Certificato certif = new Certificato();
		if(!"normale".equalsIgnoreCase(certificato.getTipo())  && !"agonistico".equalsIgnoreCase(certificato.getTipo())) {
			throw new AcademyException("Tipo non valido");
		}
		certif.setTipo(certificato.getTipo().equalsIgnoreCase("normale")? true :false); 		//se normlae true
		certif.setDataCertificato(certificato.getDataCertificato());
		certif.setSocio(socio.get());
		
		log.debug("After create certificato");

		return certifR.save(certif).getId();
	}

	@Override
	public List<CertificatoDTO> listCertificati() {
		log.debug("sassolo spassolo");
		List<Certificato> resp = certifR.findAll();
		
		return resp.stream()
				.map(s-> new CertificatoDTO(
						s.getId(),
						s.getTipo()?"normale" : "agonistico",
						s.getDataCertificato(),
						s.getSocio().getId(),
						s.getSocio().getNome(),
						s.getSocio().getCognome(),
						s.getSocio().getcFiscale()
						
						)).collect(Collectors.toList());
		
		
	}

	@Override
	public void remove(CertificatoDTO certificato) throws AcademyException {
		Optional<Certificato> certif = certifR.findById(certificato.getId());
		if(certif.isEmpty())
			throw new AcademyException("Socio sconosiuto");
		
		certifR.delete(certif.get());
	}

}
