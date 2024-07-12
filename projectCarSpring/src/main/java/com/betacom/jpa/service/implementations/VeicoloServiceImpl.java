package com.betacom.jpa.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.TipoVeicoloDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.Bici;
import com.betacom.jpa.pojo.Macchina;
import com.betacom.jpa.pojo.Moto;
import com.betacom.jpa.pojo.TipoAlimentazione;
import com.betacom.jpa.pojo.TipoColore;
import com.betacom.jpa.pojo.Veicolo;
import com.betacom.jpa.pojo.TipoMarca;
import com.betacom.jpa.pojo.TipoVeicolo;
import com.betacom.jpa.repository.IBiciRepository;
import com.betacom.jpa.repository.IMacchinaRepository;
import com.betacom.jpa.repository.IMotoRepository;
import com.betacom.jpa.repository.ITipoAlimRepository;
import com.betacom.jpa.repository.ITipoColoreRepository;
import com.betacom.jpa.repository.ITipoMarcaRepository;
import com.betacom.jpa.repository.ITipoVeicoloRepository;
import com.betacom.jpa.repository.IVeicoloRepository;
import com.betacom.jpa.service.intefaces.ITipoColoreService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@Service
public class VeicoloServiceImpl implements IveicoloService{
	@Autowired
	IVeicoloRepository vecR;
	
	@Autowired
	ITipoColoreService colS;
	
	@Autowired
	ITipoColoreRepository colR;
	
	@Autowired
	ITipoMarcaRepository marcaR;
	
	@Autowired
	ITipoVeicoloRepository tipoR;
	
	@Autowired
	ITipoAlimRepository alimR;
	
	@Autowired
	IMacchinaRepository macR;
	
	@Autowired
	IMotoRepository motoR;
	
	@Autowired
	IBiciRepository biciR;
	

	@Override
	public void createVeicolo(VeicoloDTO veicolo, Integer id) throws AcademyException {
		
		
		Veicolo vec = null;
		if(veicolo.getId() != null) {
			Optional<Veicolo> myVec= vecR.findById(veicolo.getId());
			if(myVec.isEmpty())
				throw new AcademyException("veicolo sconosciuto");
			vec = myVec.get();
		}else
			vec = new Veicolo();
		
		if(veicolo.getnPosti()<0 || veicolo.getnPosti()>7)
			throw new AcademyException("numero posti errato");
		vec.setnPosti(veicolo.getnPosti());
		
		if(veicolo.getNumeroRuote()<1 || veicolo.getNumeroRuote()>8)
			throw new AcademyException("numero ruote errato");
		vec.setNumeroRuote(veicolo.getNumeroRuote());
		
		
		Optional<TipoColore> col = colR.findByDescrizione(veicolo.getColore());
		if(col.isEmpty()) {
			throw new AcademyException("colore sconosciuto");
		}
		vec.setColore(col.get());
		
		Optional<TipoMarca> mar = marcaR.findByDescrizione(veicolo.getMarca());
		if(mar.isEmpty()) {
			throw new AcademyException("marca sconosciuto");
		}
		vec.setMarca(mar.get());
		
		Optional<TipoVeicolo> tipo = tipoR.findById(veicolo.getTipoVeicolo());
		if(tipo.isEmpty()) {
			throw new AcademyException("tipo veicolo sconosciuto");
		}
		vec.setTipoVeicolo(tipo.get());
		
		Optional<TipoAlimentazione> alim = alimR.findByDescrizione(veicolo.getTipoAlimentazione());
		if(alim.isEmpty()) {
			throw new AcademyException("tipo alimentazione sconosciuto");
		}
		vec.setTipoAlimentazione(alim.get());
		
		
		if(macR.findById(id).get() instanceof Macchina)
			vec.setMacchina(macR.findById(id).get());
		else if (motoR.findById(id).get() instanceof Moto)
			vec.setMoto(motoR.findById(id).get());
		else if (biciR.findById(id).get() instanceof Bici)
			vec.setBici(biciR.findById(id).get());

		vecR.save(vec);
	}


	@Override
	public void removeVeicolo(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		
	}


	
	
	

	
	
	

}
