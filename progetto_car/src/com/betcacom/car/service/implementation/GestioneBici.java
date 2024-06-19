package com.betcacom.car.service.implementation;
import java.util.Date;

import com.betcacom.car.exception.AcademyException;
import com.betcacom.car.oggetti.Bici;
import com.betcacom.car.oggetti.Macchina;
import com.betcacom.car.oggetti.Moto;
import com.betcacom.car.oggetti.Veicolo;
import com.betcacom.car.service.interfaces.IGestioneVeicolo;
import com.betcacom.car.service.interfaces.IgestioneSystemService;
import com.betcacom.car.singleton.MySingleton;
import com.betcacom.car.utility.Verify;

public class GestioneBici implements IGestioneVeicolo{
	
	private IgestioneSystemService gSer= new GestioneSystemService();

	@Override
	public Veicolo createVeicolo(Veicolo params) throws AcademyException{
		Bici param = (Bici) params;
		Verify v = new Verify();
		
		String error = "[";
		
		error = v.checkVeicolo(param, error);
		
		
		if(!gSer.checkTipoVeicolo(param.getTipoVeicolo(), "TipoBici")) {
			error+= "tipo obbligatorio ";
		}
		if(!gSer.checkTipoAlimentazione(param.getTipoAlimentazione(), "BiciAlimentazione")) {
			error+= "tipo alimentazione obbligatorio, ";
		}

		if(!gSer.checkMarcaBici(param.getMarca())) {
			error+= "marca obbligatorio, ";
		}
		if(param.getCestino() == null) {
			error+= "inserimento cestino obbligatorio, ";
		}
		if(param.getPieghevole() == null) {
			error+= "definire pieghevole obbligatorio, ";
		}
		if(param.getTipoUso() == null) {
			error+= "tipo d'uso obbligatorio, ";
		}
		if(param.getSospensioni() == null) {
			error+= "sospensioni obbligatorio, ";
		}
		
		
		if(error.equals("[")) {
			param.setDtaInserimento(new Date());
			param.setId(gSer.getID());
			MySingleton.getInstance().updateList(param);

		} else {
			throw new AcademyException("Bici" + error+"]");			
		}
		
		
		return param;
	}

	@Override
	public void removeVeicolo(Integer id) throws AcademyException {
		if(getVeicolo(id) instanceof Bici) {
			if (!gSer.removeItem(id)) {
				throw new AcademyException("RemoveVeicolo: Id non trovato");
			}
		}else{
			throw new AcademyException("RemoveVeicolo: deve essere una bici");
		}
		

	}

	@Override
	public Veicolo getVeicolo(Integer id) throws AcademyException {
		if(gSer.getItem(id) == null || !(gSer.getItem(id) instanceof Bici)) {
			throw new AcademyException("getBici: Id deve essere una bici");
		}
		return gSer.getItem(id);
	}
	

}
