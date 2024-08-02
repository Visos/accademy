package com.betacom.jpa.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.AttributeAccessorSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.AbbonamentoDTO;
import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.dto.AttivitaDTO;
import com.betacom.jpa.dto.AttivitaViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Attivita;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.repository.IAbbonamentoRepository;
import com.betacom.jpa.repository.IAttivitaRepository;
import com.betacom.jpa.request.AbbonamentoAttivitaReq;
import com.betacom.jpa.request.AttivitaRequest;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import com.betacom.jpa.service.interfaces.IAttivitaService;
import com.betacom.jpa.service.interfaces.IMessaggeService;

@Service
public class AttivitaImp implements IAttivitaService{

	@Autowired
	IAttivitaRepository attR;
	
	@Autowired
	IMessaggeService msgS;
	
	@Autowired
	IAbbonamentoRepository abboR;
	
	@Autowired
	IAbbonamentoService abboS;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoServiceImpl.class);

	
	@Override
	public void create(AttivitaRequest req) throws AcademyException{
		
		Optional<Attivita> a = attR.findByDescrizione(req.getDescrizione().trim());
		if(a.isPresent())
			throw new AcademyException(msgS.getMessaggioInternational("attiv-exist"));
		
		Attivita attivita = new Attivita();
		attivita.setDescrizione(req.getDescrizione());
		attR.save(attivita);

	}
	
	
	@Override
	public List<AttivitaDTO> listAll(){
		List<Attivita> a = attR.findAll();
		return transformAttInDto(a);
	}
	
	private List<AttivitaDTO> transformAttInDto(List<Attivita> resp){
		return resp.stream()
				.map(s -> new AttivitaDTO(
						s.getId(),
						s.getDescrizione()
						)).collect(Collectors.toList());
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void createAttivitaAbbonamento(AttivitaRequest req) throws AcademyException{
		Optional<Abbonamento> abb = abboR.findById(req.getAbbonamentoID());
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
		
		
//		for (String attivita:req.getAttivita()) {
//			Optional<Attivita> myAtt = attR.findByDescrizione(attivita.trim());
//			if (myAtt.isEmpty())
//				throw new AcademyException(msgS.getMessaggio("attiv-ntfnd" + attivita));
//			if (existAttivita(abb.get().getAttivita(), attivita.trim()))
//				throw new AcademyException(msgS.getMessaggio("attiv-exist-abb" + attivita));
//			abb.get().getAttivita().add(myAtt.get());
//		}
		
		
		Optional<Attivita> myAtt = attR.findById(req.getId());
		if(myAtt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-ntfnd"));
		abb.get().getAttivita().add(myAtt.get());

		abboR.save(abb.get());
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void removeAttivitaAbbonamento(AttivitaRequest req) throws AcademyException{

		Optional<Abbonamento> abb = abboR.findById(req.getAbbonamentoID());
		if (abb.isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
		
		
//		for (String attivita:req.getAttivita()) {
//			Optional<Attivita> myAtt = attR.findByDescrizione(attivita.trim());
//			if (myAtt.isEmpty())
//				throw new AcademyException(msgS.getMessaggio("attiv-ntfnd" + attivita));
//			if (!existAttivita(abb.get().getAttivita(), attivita.trim()))
//				throw new AcademyException(msgS.getMessaggio("attiv-exist-abb" + attivita));
//	        abb.ifPresent(a -> a.getAttivita().removeIf(att -> att.getDescrizione().equalsIgnoreCase(attivita)));
//			//abb.get().getAttivita().remove(myAtt.get());
//			
//		}
		Optional<Attivita> myAtt = attR.findById(req.getId());
		if (myAtt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("attiv-ntfnd"));
		
		//abb.ifPresent(a-> a.getAttivita().removeIf(att-> att.getId() == req.getId()));
		
		abb.get().getAttivita().remove(myAtt.get());
		log.debug("attivita size:" + abb.get().getAttivita().size());
		
		abboR.save(abb.get());
		log.debug("Abbonamento saved...");
		
	}
	
	public boolean removeAttivita(AttivitaRequest req) throws AcademyException{
		boolean rc = false;
		Optional<Attivita> abb = attR.findByDescrizione(req.getDescrizione());
		
		if (!(abb.isEmpty())) {
			if(!(abb.get().getAbbonamenti().isEmpty())) {
				msgS.getMessaggio("attiv-noexist-abb");
			} else {
				rc = true;
				attR.delete(abb.get());
			}
		}else
			msgS.getMessaggio("attiv-ntfnd: " + req.getDescrizione());
			
		return rc;
	}
	
	
	public List<AbbonamentoDTO> getByDescrizioneAtt(String descrizione) throws AcademyException{
		Optional<Attivita> s = attR.findByDescrizione(descrizione);
		if(s.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("attiv-nodesc"));
		}
		List<AbbonamentoDTO> abb = abboS.listInAbboDTO(attR.findByDescrizione(descrizione).get().getAbbonamenti());
		return abb;
	}
	
	
	
	
	
	private boolean existAttivita (List<Attivita> att, String search) {
		return att.stream()
				.map(Attivita::getDescrizione)
				.anyMatch(descrizione -> descrizione.equalsIgnoreCase(search));
	    }
	
	@Override
	public List<AttivitaDTO> listAttivitaByAbboo(Integer id) throws AcademyException{
		Optional<Abbonamento> abb = abboR.findById(id);
		if(abb.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
			
		}
		if(abb.get().getAttivita().isEmpty()) 
			throw new AcademyException(msgS.getMessaggio("attiv-zero"));
		else
			return transformAttInDto(abb.get().getAttivita());
						
		
	}
	
	@Override
	public List<AttivitaDTO> listAttivitaNonAbboo(Integer id) throws AcademyException{
		Optional<Abbonamento> abb = abboR.findById(id);
		if(abb.isEmpty()) {
			throw new AcademyException(msgS.getMessaggio("abbo-noexist"));
			
		}
		List<Attivita> attiv = attR.findAll();
		List<Attivita> result = new ArrayList<Attivita>();
		
		for (Attivita a : attiv) {
			if(!existAttivita(abb.get().getAttivita(), a.getDescrizione())){
				result.add(a);
			}
		}
		return transformAttInDto(result);
	
	}
	
	

	
}
