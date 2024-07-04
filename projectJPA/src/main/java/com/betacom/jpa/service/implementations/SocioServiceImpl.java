package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.process.ProcessTest;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.repository.IcertificatoRepository;
import com.betacom.jpa.service.interfaces.ISocioService;


@Service
public class SocioServiceImpl implements ISocioService{
	
	@Autowired
	ISocioRepository socioR;
	
	@Autowired
	IcertificatoRepository certifR;
	
	public static Logger log = LoggerFactory.getLogger(SocioServiceImpl.class);


	@Override
	public Integer createSocio(SocioDTO socioI) {
		Socio socio = new Socio();
		socio.setcFiscale(socioI.getcFiscale());
		socio.setCognome(socioI.getCognome());
		socio.setNome(socioI.getNome());
		
		return socioR.save(socio).getId();
		
	}

	@Override
	public List<SocioDTO> listAllSocio() {
		List<Socio> resp = socioR.findAll();
		return transformInListDTO(resp);
	}
	public List<SocioDTO> transformInListDTO(List<Socio> resp ) {
		return resp.stream()
		.map(s -> new SocioDTO(
				s.getId(),
				s.getCognome(),
				s.getNome(),
				s.getcFiscale(),
				(s.getCertificato() != null) ? s.getCertificato().getId(): null,
				(s.getCertificato() != null) ? s.getCertificato().getDataCertificato(): null,
				(s.getCertificato() != null) ? (s.getCertificato().getTipo() ?"agonistico" : "Normale"): null,
				(s.getAbbonamenti() != null) ? transformAbboInDTO(s.getAbbonamenti()): null
				))
		.collect(Collectors.toList());
	}
	
	
	@Override
	public List<SocioDTO> serachCognome(String cognome) {
		return transformInListDTO(socioR.findByCognome(cognome));

	}
	
	@Override
	public List<SocioDTO> serachCognomi(List<String> cognomi) {
	
		List<Socio> l = socioR.findByCognomeIn(cognomi);
		return transformInListDTO(l);

	}

	@Override
	public void removeSocio(SocioDTO socio) throws AcademyException{
		Optional<Socio> soc = socioR.findById(socio.getId());
		if(soc.isEmpty())
			throw new AcademyException("socio sconosciuto");
		
		if(soc.get().getCertificato() != null) {
			certifR.delete(soc.get().getCertificato());
			log.debug("certificato cancellato");
		}
		
		socioR.delete(soc.get());
	}

	@Override
	public void updateSocio(SocioDTO socio) throws AcademyException {
		Optional<Socio> soc = socioR.findById(socio.getId());
		if(soc.isEmpty())
			throw new AcademyException("socio sconosciuto");
				
		soc.get().setNome(socio.getNome());
		soc.get().setCognome(socio.getCognome());
		
		socioR.save(soc.get());
		
		log.debug("update socio " + soc.get().getNome());
		
	}
	
	private List<AbbonamentoDTO> transformAbboInDTO(List<Abbonamento> resp){
		return resp.stream()
				.map(a -> new AbbonamentoDTO(
						a.getId(),
						a.getDataIscrizione(),
						a.getSocio().getId()
						)).collect(Collectors.toList());
	}
	
//	private List<SocioDTO> transformInListDTO (List<Socio> resp){
//		
//	}

}