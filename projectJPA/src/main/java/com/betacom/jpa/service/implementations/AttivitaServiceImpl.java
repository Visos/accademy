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
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AbbonamentoView2DTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.dto.SocioDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.repository.IAbbonamentoRepository;
import com.betacom.jpa.repository.IAttivitaRepository;
import com.betacom.jpa.request.AttivitaReq;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggioService;


@Service
public class AttivitaServiceImpl implements IAttivitaService{

	@Autowired
	IAttivitaRepository attR;
	
	@Autowired
	IMessaggioService msgS;
	
	@Autowired
	IAbbonamentoRepository abboR;
	
	public static Logger log = LoggerFactory.getLogger(AttivitaServiceImpl.class);
	@Override
	public void create(AttivitaReq req) throws AcademyException {
		Optional<Attivita> a = attR.findByDescrizione(req.getDescrizione().trim());
		if (a.isPresent())
			throw new AcademyException(msgS.getMessaggioInt("attiv-exist"));
		
		Attivita attivita = new Attivita();
		attivita.setDescrizione(req.getDescrizione());
		attR.save(attivita);
	}

	@Override
	public List<AttivitaDTO> listAll() {
		List<Attivita> att = attR.findAll();
		return transformAttiInDTO(att);
	}

	private List<AttivitaDTO> transformAttiInDTO(List<Attivita> resp){
		return resp.stream()
				.map(a -> new AttivitaDTO(
						a.getId(),
						a.getDescrizione()
						))
				.collect(Collectors.toList());
	}

	@Override
	public AttivitaViewDTO list(Integer id) throws AcademyException {
		Optional<Attivita> at = attR.findById(id);
		if (at.isEmpty())
			throw new AcademyException(msgS.getMessaggioInt("attiv-ntfnd"));
		return new AttivitaViewDTO(
				at.get().getId(),
				at.get().getDescrizione(),
				transformAbboView2InDTO(at.get().getAbbonamenti()));
	}
	
	private List<AbbonamentoView2DTO> transformAbboView2InDTO(List<Abbonamento> resp){
		return resp.stream()
				.map(a -> new AbbonamentoView2DTO(
						a.getId(),
						a.getDataIscrizione(),
						a.getSocio().getId(),
						a.getSocio().getCognome(),
						a.getSocio().getNome())).collect(Collectors.toList());
	
		
	}
	
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void createAttivitaAbbonamento(AttivitaReq req) throws AcademyException{
		
		Optional<Abbonamento> abb = abboR.findById(req.getAbbonamentoID());
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
		
		
//		for (String attivita:req.getAttivita()) {
//			Optional<Attivita> myAtt = attR.findByDescrizione(attivita.trim());
//			if (myAtt.isEmpty())
//				throw new AcademyException(msgS.getMessaggio("attiv-ntfnd") + attivita);
//			if (existAttivita(abb.get().getAttivita(), attivita.trim()))
//				throw new AcademyException(msgS.getMessaggio("attiv-exist-abb") + attivita);
//			abb.get().getAttivita().add(myAtt.get());
//		}

		Optional<Attivita> myAtt = attR.findById(req.getId());
		if (myAtt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-ntfnd"));
		abb.get().getAttivita().add(myAtt.get());
		
		abboR.save(abb.get());
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void removeAttivitaAbbonamento(AttivitaReq req) throws AcademyException {
		Optional<Abbonamento> abb = abboR.findById(req.getAbbonamentoID());
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
		
		
//		for (String attivita:req.getAttivita()) {
//			Optional<Attivita> myAtt = attR.findByDescrizione(attivita.trim());
//			if (myAtt.isEmpty())
//				throw new AcademyException(msgS.getMessaggio("attiv-ntfnd") + attivita);
//			if (!existAttivita(abb.get().getAttivita(), attivita.trim()))
//				throw new AcademyException(msgS.getMessaggio("attiv-noexist-abb") + attivita);
//			
//	        abb.ifPresent(a -> a.getAttivita().removeIf(att -> att.getDescrizione().equalsIgnoreCase(attivita)));
//			
//		}
		Optional<Attivita> myAtt = attR.findById(req.getId());
		if (myAtt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-ntfnd"));

		abb.get().getAttivita().remove(myAtt.get());
		log.debug("attivita size:" + abb.get().getAttivita().size());
		
		abboR.save(abb.get());
		log.debug("Abbonamento saved...");
	}

	@Override
	public List<SocioDTO> removeAttivita(AttivitaReq req) throws AcademyException {
		Optional<Attivita> at = attR.findById(req.getId());
		if (at.isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-ntfnd"));
		if (at.get().getAbbonamenti().isEmpty())
			attR.delete(at.get());
		return buidListSocio(at.get().getAbbonamenti());
	}

	private List<SocioDTO> buidListSocio(List<Abbonamento> l){
		List<SocioDTO> r = new ArrayList<SocioDTO>();
		for (Abbonamento i:l) {
			SocioDTO s = new SocioDTO();
			s.setCognome(i.getSocio().getCognome());
			s.setNome(i.getSocio().getNome());
			s.setcFiscale(i.getSocio().getcFiscale());
			r.add(s);
		}
		return r;
		
	}
	@Override
	public List<AttivitaDTO> listByAbbonamento(Integer id) throws AcademyException {
		Optional<Abbonamento> abb = abboR.findById(id);
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));

		if (abb.get().getAttivita().isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-zero"));
		
		
		return transformAttiInDTO(abb.get().getAttivita());
	}

	@Override
	public List<AttivitaDTO> listAttivitaNonAbbonamento(Integer id) throws AcademyException {
		Optional<Abbonamento> abb = abboR.findById(id);
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
		
		List<Attivita> attiv = attR.findAll();
		List<Attivita> result = new ArrayList<Attivita>();
		for (Attivita a:attiv) {
			if (!existAttivita(abb.get().getAttivita(), a.getDescrizione()))
				result.add(a);
		}
		return transformAttiInDTO(result);
	}
	
	
	
	
	private boolean existAttivita (List<Attivita> att, String search) {
		return att.stream()
				.map(Attivita::getDescrizione)
				.anyMatch(descrizione -> descrizione.equalsIgnoreCase(search));
	    }




}
