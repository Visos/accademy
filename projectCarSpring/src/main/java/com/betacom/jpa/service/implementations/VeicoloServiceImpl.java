package com.betacom.jpa.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.MotoDTO;
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
import com.betacom.jpa.service.intefaces.IBiciService;
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
	
	@Autowired
	IBiciService biciS;
	

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
		
		if(vec.getTipoVeicolo().getId().charAt(0) == 'A')
			vec.setMacchina(macR.findById(id).get());
		else if (vec.getTipoVeicolo().getId().charAt(0) == 'M') {
			vec.setMoto(motoR.findById(id).get());
		}
		else if (vec.getTipoVeicolo().getId().charAt(0) == 'B')
			vec.setBici(biciR.findById(id).get());

		vecR.save(vec);
	}
	
	@Override
	public void createBici(BiciDTO biciI, VeicoloDTO veicolo) throws AcademyException {
		Bici bici = null;
		if(biciI.getId()!= null) {
			Optional<Bici> mybici = biciR.findById(biciI.getId());
			if(mybici.isEmpty())
				throw new AcademyException("bici sconosciuta");
			bici = mybici.get();
		}else
			bici = new Bici();
		
		bici.setPieghevole(biciI.getPieghevole());
		
		bici.setTipoUso(biciI.getTipoUso());
		
		createVeicolo(veicolo, biciR.save(bici).getId());
		
	}
	
	@Override
	public void createMacchina(MacchinaDTO macchina, VeicoloDTO veicolo) throws AcademyException {
		Macchina mac = null;
		if(macchina.getId() != null) {
			Optional<Macchina> myMac = macR.findById(macchina.getId());
			if(myMac.isEmpty())
				throw new AcademyException("macchina sconosciuta");
			mac = myMac.get();
		}else
			mac = new Macchina();

		if(macchina.getNumeroPorte()>7 || macchina.getNumeroPorte()<2) {
			throw new AcademyException("numero porte non valido");
		}
		mac.setNumeroPorte(macchina.getNumeroPorte());
		if(macchina.getNumerotarga().length()!=7) {
			throw new AcademyException("numero targa non valido");
		}
		mac.setNumerotarga(macchina.getNumerotarga());

		createVeicolo(veicolo, macR.save(mac).getId());

	}
	
	@Override
	public void createMoto(MotoDTO motoI, VeicoloDTO veicolo) throws AcademyException {
		Moto moto = null;
		if(motoI.getId()!= null) {
			Optional<Moto> mymoto = motoR.findById(motoI.getId());
			if(mymoto.isEmpty()) 
				throw new AcademyException("moto sconosciuta");
			moto = mymoto.get();
		}else
			moto = new Moto();
		
		if(motoI.getCc()<50 || motoI.getCc()>2000) {
			throw new AcademyException("cc non valido");
		}
		moto.setCc(motoI.getCc());
		if(motoI.getTarga().length()!=7) {
			throw new AcademyException("numero targa non valido");
		}
		moto.setTarga(motoI.getTarga());
		createVeicolo(veicolo, motoR.save(moto).getId());
	}
	
	
	
	
	

	@Override
	public List<VeicoloDTO> listAll() {
		List<Veicolo> v = vecR.findAll();
		
		return transformInDto(v);
	}
	
	public List<VeicoloDTO> transformInDto(List<Veicolo> resp){
		return resp.stream()
				.map(s-> new VeicoloDTO(
						s.getId(),
						s.getTipoAlimentazione().getDescrizione(),
						s.getColore().getDescrizione(),
						s.getTipoVeicolo().getDescrizione(),
						s.getNumeroRuote(),
						s.getnPosti(),
						s.getMarca().getDescrizione(),
						(s.getBici() == null ? null : new BiciDTO(
								s.getBici().getId(),
								s.getBici().getTipoUso(),
								s.getBici().getPieghevole(),
								s.getBici().getVeicolo().getId(),
								biciS.transformAmmoInDto(s.getBici().getSospensioni())
								)),
						(s.getMacchina() == null ? null : new MacchinaDTO(
								s.getMacchina().getId(),
								s.getMacchina().getNumeroPorte(),
								s.getMacchina().getNumerotarga(),
								s.getMacchina().getVeicolo().getId()
								)),
						(s.getMoto() == null ? null : new MotoDTO(
								s.getMoto().getId(),
								s.getMoto().getTarga(),
								s.getMoto().getCc(),
								s.getMoto().getVeicolo().getId()
									))
						)).collect(Collectors.toList());
		
	}
	
	@Override
	public void removeVeicolo(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		
	}
	
	


	
	
	

	
	
	

}
