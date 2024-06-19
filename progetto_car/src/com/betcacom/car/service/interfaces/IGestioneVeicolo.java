package com.betcacom.car.service.interfaces;

import com.betcacom.car.exception.AcademyException;
import com.betcacom.car.oggetti.Veicolo;

public interface IGestioneVeicolo{
	Veicolo createVeicolo(Veicolo params) throws AcademyException;
	void removeVeicolo(Integer id) throws AcademyException;
	Veicolo getVeicolo(Integer id) throws AcademyException;
}
