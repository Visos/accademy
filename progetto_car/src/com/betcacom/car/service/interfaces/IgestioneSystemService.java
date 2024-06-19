package com.betcacom.car.service.interfaces;

import java.util.List;

import com.betcacom.car.oggetti.Veicolo;

public interface IgestioneSystemService extends IGestioneSystem{
	
	public int getID();
	public void updateList(	Veicolo ob);
	public boolean removeItem(int id);
	public Veicolo getItem(Integer id);
	public List<Veicolo> getList();

	//------MACCHINA
	public boolean checkTipoVeicolo(String tipo, String tipoVeicolo);
	public boolean checkTipoAlimentazione(String tipoAlimentazione, String string);

	
	
	public boolean checkMarcaAuto(String tipo);
	
	//-----MOTO

	public boolean checkMarcaMoto(String tipo);
	
	//------BICI

	public boolean checkMarcaBici(String tipo);

	
	
	

}
