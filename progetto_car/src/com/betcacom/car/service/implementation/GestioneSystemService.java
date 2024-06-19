package com.betcacom.car.service.implementation;

import java.util.List;

import com.betcacom.car.oggetti.Veicolo;
import com.betcacom.car.service.interfaces.IgestioneSystemService;
import com.betcacom.car.singleton.MySingleton;

public class GestioneSystemService extends GestioneSystem implements IgestioneSystemService {


	@Override
	public List<Veicolo> getList() {
		return MySingleton.getInstance().getList();
	}

	@Override
	public int getID() {
		return MySingleton.getInstance().getID();
	}

	@Override
	public void updateList(Veicolo ob) {
		MySingleton.getInstance().updateList(ob);
	}

	@Override
	public boolean removeItem(int id) {
		return MySingleton.getInstance().removeItem(id);
	}

	@Override
	public Veicolo getItem(Integer id) {
		return MySingleton.getInstance().getItem(id);
	}

	@Override
	public boolean checkTipoVeicolo(String tipo, String tipoVeicolo) {
		return MySingleton.getInstance().checkTipoVeicolo(tipo, tipoVeicolo);
	}

	@Override
	public boolean checkMarcaAuto(String tipo) {
		return MySingleton.getInstance().checkMarcaAuto(tipo);
	}


	@Override
	public boolean checkMarcaMoto(String tipo) {
		return MySingleton.getInstance().checkMarcaMoto(tipo);
	}

	@Override
	public boolean checkMarcaBici(String tipo) {
		return MySingleton.getInstance().checkMarcaBici(tipo);
	}

	@Override
	public boolean checkTipoAlimentazione(String tipo, String TipoAlim) {
		return MySingleton.getInstance().checkTipoAlimentazione(tipo, TipoAlim);
	}



}
