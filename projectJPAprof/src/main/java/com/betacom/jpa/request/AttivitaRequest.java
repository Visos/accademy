package com.betacom.jpa.request;

import java.util.Arrays;

public class AttivitaRequest {
	
	private Integer id;
	private String  descrizione;
	private Integer abbonamentoID;
	private String[] attivita;
	private Integer socioID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getAbbonamentoID() {
		return abbonamentoID;
	}
	public void setAbbonamentoID(Integer abbonamentoID) {
		this.abbonamentoID = abbonamentoID;
	}
	public String[] getAttivita() {
		return attivita;
	}
	public void setAttivita(String[] attivita) {
		this.attivita = attivita;
	}
	public Integer getSocioID() {
		return socioID;
	}
	public void setSocioID(Integer socioID) {
		this.socioID = socioID;
	}
	
	


	
	

}
