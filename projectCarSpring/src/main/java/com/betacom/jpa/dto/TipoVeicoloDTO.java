package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.Veicolo;

public class TipoVeicoloDTO {
	
	private String id;
	
	private String descrizione;
	
	private List<Veicolo> veicoli;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Veicolo> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(List<Veicolo> veicoli) {
		this.veicoli = veicoli;
	}
	
	


}
