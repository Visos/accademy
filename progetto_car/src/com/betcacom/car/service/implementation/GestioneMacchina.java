package com.betcacom.car.service.implementation;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.betcacom.car.exception.AcademyException;
import com.betcacom.car.oggetti.Macchina;
import com.betcacom.car.oggetti.Veicolo;
import com.betcacom.car.service.interfaces.IGestioneSystem;
import com.betcacom.car.service.interfaces.IGestioneVeicolo;
import com.betcacom.car.service.interfaces.IgestioneSystemService;
import com.betcacom.car.utility.Verify;


public class GestioneMacchina implements IGestioneVeicolo{
	
	private IgestioneSystemService gSer= new GestioneSystemService();

	@Override
	public Veicolo createVeicolo(Veicolo params) throws AcademyException {
		Macchina param = (Macchina) params;
		Verify v = new Verify();
		String error = "[";
		/*
		//da generalizzare tutti i controlli dei parametri di veicolo
		//implementare meglio i controlli(ruote>0, Tipo veicolo [bici, moto, macchina]
*/
		
		error = v.checkVeicolo(param, error);
		
		
		if(!gSer.checkTipoVeicolo(param.getTipoVeicolo(),  "TipoMacchina")) {
			error+= "tipo obbligatorio ";
		}
		//-----------------
		if(!gSer.checkTipoAlimentazione(param.getTipoAlimentazione(), "MacchinaAlimentazione")) {
			error+= "tipo alimentazione obbligatorio, ";
		}
		if(!gSer.checkMarcaAuto(param.getMarca())) {
			error+= "marca obbligatorio, ";
		}
		
		
		
		if(param.getCc() == null) {
			error+= "Cc obbligatorio, ";
		}
		if(param.getNumerotarga() == null) {
			error+= "n. targa obbligatorio, ";
		}
		if(error.equals("[")) {
			
			param.setDtaInserimento(new Date());
			Macchina.numeroMacchina++;
			param.setId(gSer.getID());
			gSer.updateList(param);

		} else {
			Macchina.numeroErrori++;
			throw new AcademyException("Macchina "+error+"]");
		}

		
		return param;
	
	}

		@Override
		public void removeVeicolo(Integer id) throws AcademyException {
			if(getVeicolo(id) instanceof Macchina) {
				if (!gSer.removeItem(id)) {
					throw new AcademyException("RemoveVeicolo: Id non trovato");
				}
			}else{
				throw new AcademyException("RemoveVeicolo: deve essere una Macchina");
			}
			

		}

		@Override
		public Veicolo getVeicolo(Integer id) throws AcademyException {
			if(gSer.getItem(id) == null || !(gSer.getItem(id) instanceof Macchina)) {
				throw new AcademyException("getMacchina: Id deve essere di una macchina");
			}
			return gSer.getItem(id);
		}


}
