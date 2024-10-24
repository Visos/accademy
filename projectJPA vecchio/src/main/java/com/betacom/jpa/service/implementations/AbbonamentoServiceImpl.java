package com.betacom.jpa.service.implementations;

import static com.betacom.jpa.util.Utilities.loadListViewAbbonamentoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Abbonamento;
import com.betacom.jpa.pojo.Socio;
import com.betacom.jpa.repository.IAbbonamentoRepository;
import com.betacom.jpa.repository.IAttivitaRepository;
import com.betacom.jpa.repository.ISocioRepository;
import com.betacom.jpa.request.AbbonamentoReq;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;
import com.betacom.jpa.service.interfaces.IMessaggioService;
@Service
public class AbbonamentoServiceImpl implements IAbbonamentoService{
	
	@Autowired
	IAbbonamentoRepository abboR;
	
	@Autowired
	ISocioRepository socioR;
	
	@Autowired
	IAttivitaRepository attiR;
	
	@Autowired
	IMessaggioService msgS;
	
	public static Logger log = LoggerFactory.getLogger(AbbonamentoServiceImpl.class);
	@Override
	public Integer create(AbbonamentoReq abbo) throws AcademyException {
		Optional<Socio> soc = socioR.findById(abbo.getSocioID());
		if (soc.isEmpty())
			throw new AcademyException(msgS.getMessaggio("socio-ntfnd"));
		Abbonamento abb = new Abbonamento();
		abb.setDataIscrizione(abbo.getDataIscrizione());
		abb.setSocio(soc.get());
		return abboR.save(abb).getId();
		
	}
	@Override
	public List<AbbonamentoViewDTO> listAbbonamenti(Integer id) throws AcademyException {
		List<Abbonamento> r = new ArrayList<Abbonamento>();
		if (id == null)
			r = abboR.findAll();
		else {
			Optional<Abbonamento> ab = abboR.findById(id);
			if (ab.isEmpty())
				throw new AcademyException(msgS.getMessaggio("abbonamento-ntfnd"));
			r.add(ab.get());
		}
		
		return loadListViewAbbonamentoDTO(r);
	}
	@Override
	public List<AbbonamentoViewDTO> listAbbonamentiBySocio(Integer id) throws AcademyException {
		Optional<Socio> optional = socioR.findById(id);
		if (optional.isEmpty())
			throw new AcademyException(msgS.getMessaggio("socio-ntfnd"));

		if(optional.get().getAbbonamenti().isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbonamento-empty"));
	
		else 
			return loadListViewAbbonamentoDTO(optional.get().getAbbonamenti());
	}
	
	@Override
	public void removeAbbonamento(Integer id) throws AcademyException {
		Optional<Abbonamento> abbo = abboR.findById(id);
        if (abbo.isEmpty())
            throw new AcademyException(msgS.getMessaggio("abbonamento-ntfnd"));
		if (!abbo.get().getAttivita().isEmpty())
			throw new AcademyException(msgS.getMessaggio("abbonamento-no-delete"));
        
		abboR.delete(abbo.get());
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void forseRemoveAbbonamento(Integer id) throws AcademyException {
	
		Optional<Abbonamento> abbo = abboR.findById(id);
        if (abbo.isEmpty())
            throw new AcademyException(msgS.getMessaggio("abbonamento-ntfnd"));
        
        abbo.get().getAttivita().clear();
		abboR.save(abbo.get());
		abboR.delete(abbo.get());
    }
	  
}
