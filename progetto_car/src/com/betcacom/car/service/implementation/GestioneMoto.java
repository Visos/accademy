package com.betcacom.car.service.implementation;
import java.util.Date;

import com.betcacom.car.exception.AcademyException;
import com.betcacom.car.oggetti.Macchina;
import com.betcacom.car.oggetti.Moto;
import com.betcacom.car.oggetti.Veicolo;
import com.betcacom.car.service.interfaces.IGestioneVeicolo;
import com.betcacom.car.service.interfaces.IgestioneSystemService;
import com.betcacom.car.singleton.MySingleton;
import com.betcacom.car.utility.Verify;

public class GestioneMoto implements IGestioneVeicolo{
	
	private IgestioneSystemService gSer= new GestioneSystemService();

	@Override
	public Veicolo createVeicolo(Veicolo params) throws AcademyException {
		Moto param = (Moto) params;
		String error = "[";
		Verify v = new Verify();
		
		
		error = v.checkVeicolo(param, error);
		if(!gSer.checkTipoVeicolo(param.getTipoVeicolo(), "TipoMoto")) {
			error+= "tipo obbligatorio ";
		}
		if(!gSer.checkMarcaMoto(param.getMarca())) {
			error+= "marca obbligatorio, ";
		}
		if(!gSer.checkTipoAlimentazione(param.getTipoAlimentazione(), "MotoAlimentazione")) {
			error+= "tipo alimentazione obbligatorio, ";
		}
		
		
		
		if(param.getCc() == null) {
			error+= "Cc obligatorio, ";
		}
		if(param.getNumeroTarga() == null) {
			error+= "N. targa obbligatorio";
		}
		
		
		
		if(error.equals("[")) {
			param.setDtaInserimento(new Date());
			param.setId(gSer.getID());
			gSer.updateList(param);

		} else {
			throw new AcademyException("Moto" + error+"]");			
		}
		return param;
	}

	@Override
	public void removeVeicolo(Integer id) throws AcademyException {
		if(getVeicolo(id) instanceof Moto) {
			if (!gSer.removeItem(id)) {
				throw new AcademyException("RemoveVeicolo: Id non trovato");
			}
			
		}else {
			throw new AcademyException("RemoveVeicolo: deve essere una moto");
		}
		

	}

	@Override
	public Veicolo getVeicolo(Integer id) throws AcademyException {
		if(gSer.getItem(id) == null || !(gSer.getItem(id) instanceof Moto)) {
			throw new AcademyException("getMoto: Id deve essere una moto");
		}
		return gSer.getItem(id);
	}

}
