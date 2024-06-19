package com.betcacom.car.service.implementation;

import java.util.List;

import com.betcacom.car.oggetti.Veicolo;
import com.betcacom.car.service.interfaces.IGestioneSystem;
import com.betcacom.car.singleton.MySingleton;

public class GestioneSystem implements IGestioneSystem{


	@Override
	public List<Veicolo> getList() {
		return MySingleton.getInstance().getList();
	}

}
