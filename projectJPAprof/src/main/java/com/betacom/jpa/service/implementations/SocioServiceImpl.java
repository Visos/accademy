package com.betacom.jpa.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.CertificatoViewDto;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.pojo.Certificato;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.process.ProcessTestJPA;
import com.betacom.jpa.repository.ICertificatoRepository;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.service.interfaces.IMessaggeService;
import com.betacom.jpa.service.interfaces.ISocioService;

@Service
public class SocioServiceImpl implements ISocioService{
	
	@Autowired
	ISocioRepository socioR;
	
	@Autowired
	ICertificatoRepository certifR;
	
	@Autowired
	IMessaggeService msgS;
	
	public static Logger log = LoggerFactory.getLogger(SocioServiceImpl.class);
	
	@Override
	public void createUpdateSocio(SocioDTO socioI) throws AcademyException {
		Socio socio = null;
		if (socioI.getId() != null) {
			Optional<Socio> mySocio = socioR.findById(socioI.getId());
			if (mySocio.isEmpty())
				throw new AcademyException(msgS.getMessaggio("socio-non-trovato"));
			socio = mySocio.get();
		} else
			socio = new Socio();
		
		socio.setcFiscale(socioI.getcFiscale());
		socio.setCognome(socioI.getCognome());
		socio.setNome(socioI.getNome());
		try {
			socioR.save(socio);
		} catch (Exception e) {
//			throw new AcademyException(msgS.getMessaggio("socio-generico") + e.getMessage());
			throw new AcademyException(msgS.getMessaggio("socio-cfiscale"));

		}
	}

	@Override
	public List<SocioViewDTO> listAllSocio(Integer id, String nome, String cognome) {
		List<Socio> resp = new ArrayList<Socio>();
		if(id != null) {
			nome = null;
			cognome = null;
			}else {
				if (nome == null) 
					nome = "";
				
				if (cognome == null)
					cognome = "";

		}
		resp = socioR.findSocioByNomeCognome(id, nome, cognome);
		return tranformInListViewDTO(resp);
	}

	@Override
	public List<SocioDTO> searchCognome(String cognome) {
		return tranformInListDTO(socioR.findByCognome(cognome));
	}

	@Override
	public List<SocioDTO> searchCognomi(List<String> cognomi) {
		
		List<Socio> lS =socioR.findByCognomeIn(cognomi);
		return tranformInListDTO(lS);
		
	}
	
	@Override
	public List<SocioDTO> searchCognomiLike(String pattern) {
		List<Socio> lS =socioR.findByCognomeLike(pattern);
		
		return tranformInListDTO(lS);
	}

	@Override
	public List<SocioDTO> searchByAttivia(String attivita) {
		List<Socio> lS =socioR.findSocioByAttivita(attivita);
		return tranformInListDTO(lS);
	}


	
	@Override
	public void removeSocio(SocioDTO socio) throws AcademyException {
		Optional<Socio> soc = socioR.findById(socio.getId());
		if (soc.isEmpty())
			throw new AcademyException(msgS.getMessaggio("socio-non-trovato"));

		/*
		if (soc.get().getCertificato() != null) {
			certifR.delete(soc.get().getCertificato());
			log.debug("certificato cancellato");
		}
		
		
		if(soc.get().getAbbonamenti() != null) {
			for(Abbonamento abb :soc.get().getAbbonamenti()) {				
				abb.getAttivita().clear();
			}
			soc.get().getAbbonamenti().clear();
		}
		
		socioR.save(soc.get());
		*/
		
		socioR.delete(soc.get());
		
	}

	
	
	
	private List<SocioDTO> tranformInListDTO(List<Socio> resp){
		return resp.stream()
				.map(s -> new SocioDTO(
						s.getId(),
						s.getCognome(),
						s.getNome(),
						s.getcFiscale(),
						(s.getCertificato() != null) ? s.getCertificato().getId() : null,
						(s.getCertificato() != null) ? s.getCertificato().getDataCertificato() : null,
						(s.getCertificato() != null) ? (s.getCertificato().getTipo() ? "Agonistico" : "Normale") : null,
						(s.getAbbonamenti() != null) ? transformAbboInDTO(s.getAbbonamenti()) : null
						)) 
				.collect(Collectors.toList());
		
	}

	private List<SocioViewDTO> tranformInListViewDTO(List<Socio> resp){
		return resp.stream()
				.map(s -> new SocioViewDTO(
						s.getId(),
						s.getCognome(),
						s.getNome(),
						s.getcFiscale(),
						loadCertificato(s.getCertificato()),
						loadListViewAbbDto(s.getAbbonamenti())
						))
				.collect(Collectors.toList());
		
	}
	
	
	private CertificatoViewDto loadCertificato (Certificato certificato) {
		if(certificato == null)
			return new CertificatoViewDto();
		CertificatoViewDto c = new CertificatoViewDto();
				c.setId(certificato.getId());
				c.setTipo(certificato.getTipo() ? "agonistico" : "normale");
				c.setDataCertificato(certificato.getDataCertificato());
				return c;
		
	}

	
	
	private List<AbbonamentoDTO> transformAbboInDTO(List<Abbonamento> resp){
		return resp.stream()
				.map(a -> new AbbonamentoDTO(
						a.getId(),
						a.getDataIscrizione(),
						0
						))
				.collect(Collectors.toList());
	}
	
	public List<AbbonamentoViewDTO> loadListViewAbbDto (List<Abbonamento> resp){
		return resp.stream()
				.map(s-> new AbbonamentoViewDTO(
						s.getId(),
						s.getDataIscrizione(),
						transformAttivitaInDTO(s.getAttivita())
						)).collect(Collectors.toList());
	}
	
	
	public List<AttivitaDTO> transformAttivitaInDTO(List<Attivita> resp){
		return resp.stream()
		.map(s-> new AttivitaDTO(
				s.getId(),
				s.getDescrizione()
				)).collect(Collectors.toList());
	}

	@Override
	public SocioViewDTO searchById(Integer id) {
		Optional<Socio> s= socioR.findById(id);
		
		if(s.isEmpty()) {
			
		}
		SocioViewDTO v = new SocioViewDTO(
				s.get().getId(),
				s.get().getCognome(),
				s.get().getNome(),
				s.get().getcFiscale(),
				loadCertificato(s.get().getCertificato()),
				loadListViewAbbDto(s.get().getAbbonamenti())
				);
		return v;
	}




}
