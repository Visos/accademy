package com.betacom.jpa.process;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.BiciDTO;
import com.betacom.jpa.dto.BiciViewDto;
import com.betacom.jpa.dto.MacchinaDTO;
import com.betacom.jpa.dto.MacchinaViewDto;
import com.betacom.jpa.dto.MarcaDTO;
import com.betacom.jpa.dto.MotoDTO;
import com.betacom.jpa.dto.MotoViewDto;
import com.betacom.jpa.dto.TipoAlimentazioneDTO;
import com.betacom.jpa.dto.TipoAmmortizzatoreDTO;
import com.betacom.jpa.dto.TipoColoreDTO;
import com.betacom.jpa.dto.TipoVeicoloDTO;
import com.betacom.jpa.dto.VeicoloDTO;
import com.betacom.jpa.exception.AcademyException;
import com.betacom.jpa.pojo.TipoMarca;
import com.betacom.jpa.pojo.Veicolo;
import com.betacom.jpa.repository.ITipoVeicoloRepository;
import com.betacom.jpa.repository.IVeicoloRepository;
import com.betacom.jpa.request.RequestBiciAmmortizzatori;
import com.betacom.jpa.service.intefaces.IBiciService;
import com.betacom.jpa.service.intefaces.IMacchinaService;
import com.betacom.jpa.service.intefaces.IMotoService;
import com.betacom.jpa.service.intefaces.ITipoAlimentazioneService;
import com.betacom.jpa.service.intefaces.ITipoAmmortizzatoreService;
import com.betacom.jpa.service.intefaces.ITipoColoreService;
import com.betacom.jpa.service.intefaces.ITipoMarcaService;
import com.betacom.jpa.service.intefaces.ITipoVeicoloService;
import com.betacom.jpa.service.intefaces.IveicoloService;

@Service
public class ProcessTest {
	
	@Autowired
	private ITipoAmmortizzatoreService ammoS;
	
	@Autowired
	private ITipoAlimentazioneService alimS;
	
	@Autowired
	private ITipoColoreService coloS;
	
	@Autowired
	private ITipoVeicoloService tipoS;
		
	@Autowired
	private IMacchinaService maccS;
	
	@Autowired
	private IMotoService motoS;
	
	@Autowired
	private ITipoMarcaService marcaS;
	
	@Autowired
	private IveicoloService vecS;
	
	@Autowired
	IBiciService biciS;
	
	public static Logger log = LoggerFactory.getLogger(ProcessTest.class);
	
	List<TipoAlimentazioneDTO> lAlim = new ArrayList();
	List<TipoColoreDTO> lColor = new  ArrayList();
	List<TipoAmmortizzatoreDTO> lAmmo = new ArrayList();
	List<MarcaDTO> lMarca = new ArrayList();
	List<TipoVeicoloDTO> lTipo = new ArrayList();
	
	
	public void execute() {
//		createAmmortizzatori();
//		createMarca();
//		createAlim();
//		createColore();
//		createTipoVeicolo();
//		createMacchina();
//		createMoto();
//		createBici();
//		createBiciAmmortizzatore(12, new String[] { "assurdo", "ccezionale"});
//		removeMacchina();
//		removeMoto();
		
//		listMoto();
//		listMacchine();
//		listBici();
//		listVeicoli();

		

		
	}

	
	private void createAmmortizzatori() {
		log.info("inizio create ammortizzatori");
		
		
		TipoAmmortizzatoreDTO input= new TipoAmmortizzatoreDTO();
		input.setId(1);
		input.setDescrizione("assurdo");
		
		lAmmo.add(input);
		ammoS.createAmmortizzatore(input);

		
		input= new TipoAmmortizzatoreDTO();
		input.setId(2);
		input.setDescrizione("aggiunto");
		
		lAmmo.add(input);
		ammoS.createAmmortizzatore(input);

		
	}
	
	private void createMarca() {
		log.info("inizio create Marca");
		MarcaDTO input = new MarcaDTO();
		input.setId(1);
		input.setDescrizione("Ferrari");
		
		lMarca.add(input);
		marcaS.createMarca(input);
		
		input = new MarcaDTO();
		input.setId(2);
		input.setDescrizione("Lamborghini");
		
		lMarca.add(input);
		marcaS.createMarca(input);
		
		input = new MarcaDTO();
		input.setId(3);
		input.setDescrizione("Ducati");
		
		lMarca.add(input);
		marcaS.createMarca(input);
		
		input = new MarcaDTO();
		input.setId(4);
		input.setDescrizione("Aurora");
		
		lMarca.add(input);
		marcaS.createMarca(input);
	}
	
	private void createAlim() {
		log.info("inizio create Alim");
		TipoAlimentazioneDTO input = new TipoAlimentazioneDTO();
//		input.setCode(1);
//		input.setDescrizione("benzina");
//		alimS.createAlimentazione(input);
//		lAlim.add(input);
//		
//		input = new TipoAlimentazioneDTO();
//		input.setCode(2);
//		input.setDescrizione("disel");
//		alimS.createAlimentazione(input);
//		lAlim.add(input);
//		
//		input = new TipoAlimentazioneDTO();
//		input.setCode(3);
//		input.setDescrizione("gas");
//		alimS.createAlimentazione(input);
//		lAlim.add(input);
//		
//		 input = new TipoAlimentazioneDTO();
//		input.setCode(4);
//		input.setDescrizione("metano");
//		alimS.createAlimentazione(input);
//		lAlim.add(input);
		
		input = new TipoAlimentazioneDTO();
		input.setCode(5);
		input.setDescrizione("pedali");
		alimS.createAlimentazione(input);
		lAlim.add(input);
	}
	
	private void createColore() {
		log.info("creazione colore");
		TipoColoreDTO input = new TipoColoreDTO();
		input.setCode(1);
		input.setDescrizione("rosso");
		
		coloS.createTipoColore(input);
		lColor.add(input);
		
		input = new TipoColoreDTO();
		input.setCode(2);
		input.setDescrizione("blu");
		
		coloS.createTipoColore(input);
		lColor.add(input);
		
		input = new TipoColoreDTO();
		input.setCode(3);
		input.setDescrizione("giallo");
		
		coloS.createTipoColore(input);
		lColor.add(input);

	}
	
	private void createTipoVeicolo() {
		log.info("creazione tipo Veicolo");
		TipoVeicoloDTO input = new TipoVeicoloDTO();
		input.setId("A-1");
		input.setDescrizione("Berlina");
		tipoS.createTipVeicolo(input);
		lTipo.add(input);
		
		input = new TipoVeicoloDTO();
		input.setId("B-1");
		input.setDescrizione("Strada");
		tipoS.createTipVeicolo(input);
		lTipo.add(input);

		
		input = new TipoVeicoloDTO();
		input.setId("M-1");
		input.setDescrizione("Scooter");
		tipoS.createTipVeicolo(input);
		lTipo.add(input);


	}
	
	
	private void createMacchina() {
		log.info("creazione macchina");
		MacchinaDTO inputM = new MacchinaDTO();
		inputM.setNumeroPorte(4);
		inputM.setNumerotarga("1232267");
		
		VeicoloDTO inputV = new VeicoloDTO();
		inputV.setnPosti(5);
		inputV.setNumeroRuote(4);
		inputV.setColore("rosso");
		inputV.setMarca("Ferrari");
		inputV.setTipoAlimentazione("Disel");
		inputV.setTipoVeicolo("A-1");
		
		
		try {
			vecS.createMacchina(inputM, inputV);			
		} catch (AcademyException e) {
			System.out.println("erroe in creazione macchina: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	private void createMoto() {
		log.info("creazione moto");
		MotoDTO input = new MotoDTO();
		input.setCc(500);
		input.setTarga("fvbhfvh");
		
		VeicoloDTO inputV = new VeicoloDTO();
		inputV.setnPosti(2);
		inputV.setNumeroRuote(2);
		inputV.setColore("blu");
		inputV.setMarca("Ducati");
		inputV.setTipoAlimentazione("disel");
		inputV.setTipoVeicolo("M-1");
		
		try {
			vecS.createMoto(input, inputV);
		} catch (AcademyException e) {
			System.out.println("erroe in creazione macchina: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void createBici() {
		log.info("creazione bici");
		BiciDTO input = new BiciDTO();
		input.setPieghevole(false);
		input.setTipoUso("sterrato");
		
		VeicoloDTO inputV = new VeicoloDTO();
		inputV.setnPosti(1);
		inputV.setNumeroRuote(2);
		inputV.setColore("giallo");
		inputV.setMarca("Aurora");
		inputV.setTipoAlimentazione("pedali");
		inputV.setTipoVeicolo("B-1");
		
		
		try {
			vecS.createBici(input, inputV);
		} catch (AcademyException e) {
			System.out.println("erroe in creazione bici: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void createBiciAmmortizzatore(Integer id, String [] ammortizzatori) {
		RequestBiciAmmortizzatori req = new RequestBiciAmmortizzatori(id, ammortizzatori);
		
		try {
			biciS.createAmmortizzatore(req);
		} catch (AcademyException e) {
			System.out.println("errore in creazione bici/ammortizzatore:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void removeMacchina() {
		try {
			maccS.removeMacchina(3);
		} catch (AcademyException e) {
			System.out.println("errore in remove macchina" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void removeMoto() {
		try {
			motoS.removeMoto(4);
		} catch (AcademyException e) {
			System.out.println("errore in remove macchina" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void removeBici() {
		try {
			biciS.removeBici(5);
		} catch (AcademyException e) {
			System.out.println("errore in remove macchina" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void listMacchine() {

		List<MacchinaViewDto> l = maccS.listAllMacchine();
		log.info("-----------------LISTA MACCHINE-----------");

		l.forEach(m-> System.out.println(m.toString()));

	}
	
	private void listMoto() {

		List<MotoViewDto> l = motoS.listAllMoto();
		log.info("-----------------LISTA MOTO-----------");

		l.forEach(m-> System.out.println(m.toString()));

	}
	
	private void listBici() {

		List<BiciViewDto> l = biciS.listAllBici();
		log.info("-----------------LISTA BICI-----------");

		l.forEach(m-> System.out.println(m.toString()));

	}
	
	private void listVeicoli() {
		List<VeicoloDTO> l = vecS.listAll();
		log.info("-----------------LISTA Veicoli-----------");

		l.forEach(m-> System.out.println(m.toString()));
	}



}
