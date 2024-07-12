package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.Veicolo;

public class TipoColoreDTO {
	
	private Integer code;
	private String descrizione;
	private List<Veicolo> veicoloid;
	
	
	
	
	
	
	public List<Veicolo> getVeicoloid() {
		return veicoloid;
	}
	public void setVeicoli(List<Veicolo> veicoloid) {
		this.veicoloid = veicoloid;
	}
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
	
	
	
	

}
