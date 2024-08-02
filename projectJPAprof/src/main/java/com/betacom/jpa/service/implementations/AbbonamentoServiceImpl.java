package com.betacom.jpa.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.SocioViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.repository.IAbbonamentoRepository;
import com.betacom.jpa.repository.IAttivitaRepository;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import com.betacom.jpa.service.interfaces.IMessaggeService;
import com.betacom.jpa.service.interfaces.ISocioService;

import jakarta.transaction.Transactional;

@Service
public class AbbonamentoServiceImpl implements IAbbonamentoService{
	
	@Autowired
	IAbbonamentoRepository abboR;
	
	@Autowired
	ISocioRepository socioR;
	
	@Autowired
	ISocioService socioS;
	
	@Autowired
	IAttivitaRepository attiR;
	
	@Autowired
	IMessaggeService msgS;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoServiceImpl.class);
	
	
	@Override
	public Integer create(AbbonamentoReq abbo) throws AcademyException {
		System.out.println(abbo.toString());
		Optional<Socio> soc = socioR.findById(abbo.getSocioID());
		if (soc.isEmpty())
			throw new AcademyException(msgS.getMessaggio("socio-non-trovato"));
		Abbonamento abb = new Abbonamento();
		abb.setDataIscrizione(abbo.getDataIscrizione());
		abb.setSocio(soc.get());
		return abboR.save(abb).getId();
		
	}

	

	
	private boolean existAttivita (Set<Attivita> att, String search) {
		return att.stream()
				.map(Attivita::getDescrizione)
				.anyMatch(descrizione -> descrizione.equalsIgnoreCase(search));
	   }
	
	public List<AbbonamentoViewDTO> listAbbonamento(Integer id) throws AcademyException{
		List<AbbonamentoViewDTO> l = new ArrayList<AbbonamentoViewDTO>();

		if(id != null) {
			Optional<Abbonamento> abb = abboR.findById(id);
			if (abb.isEmpty()) {
				l = socioS.loadListViewAbbDto(abboR.findAll());
				msgS.getMessaggio("abbo-noexist");		
			}else {
				AbbonamentoViewDTO abboanmento = new AbbonamentoViewDTO(id, abb.get().getDataIscrizione(), socioS.transformAttivitaInDTO(abb.get().getAttivita()));
				l.add(abboanmento);
			}
		}else 
			l = socioS.loadListViewAbbDto(abboR.findAll());
		
		return l;
			
	}
	
	public List<AbbonamentoDTO> listInAbboDTO(List<Abbonamento> resp){
		return resp.stream()
				.map(s-> new AbbonamentoDTO(
						s.getId(),
						s.getDataIscrizione(),
						s.getSocio().getId()
						)).collect(Collectors.toList());
	}
	
	@Override
	public List<AbbonamentoViewDTO> listAbbonamentiBySocio(Integer id) throws AcademyException{
		Optional<Socio> soc = socioR.findById(id);
		if(soc.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("socio-non-trovato"));
			
		}
		if(soc.get().getAbbonamenti().isEmpty()) 
			throw new AcademyException(msgS.getMessaggio("abbo-zero"));
		else
			return socioS.loadListViewAbbDto(soc.get().getAbbonamenti());
		
	}
	
	@Override
	public void removeAbbonamento(Integer id) throws AcademyException{
		Optional<Abbonamento> abbo = abboR.findById(id);
		if(abbo.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));		
		if(!abbo.get().getAttivita().isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-noempty"));	
		
		System.out.println(abbo.get().getId());
		abboR.delete(abbo.get());
			
	}
	
	public void forseRemoveAbbonamento(Integer id) throws AcademyException{
		Optional<Abbonamento> abbo = abboR.findById(id);
		if(abbo.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));		
		abbo.get().getAttivita().clear();
	
		abboR.save(abbo.get());
		abboR.delete(abbo.get());
			
	}
	
	
	



}
