package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.Veicolo;

public class TipoAlimentazioneDTO {
	
	private Integer code;
	private String descrizione;
	private List<Veicolo> veicoli;
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
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
