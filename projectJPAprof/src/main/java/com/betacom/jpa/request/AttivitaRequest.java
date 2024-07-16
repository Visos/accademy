package com.betacom.jpa.request;

public class AttivitaRequest {
	
	private Integer id;
	private String descrizione;
	private Integer abbonamentoId;
	private String[] attivita;
	
	
	public String[] getAttivita() {
		return attivita;
	}
	public void setAttivita(String[] attivita) {
		this.attivita = attivita;
	}
	public Integer getAbbonamentoId() {
		return abbonamentoId;
	}
	public void setAbbonamentoId(Integer abbonamentoId) {
		this.abbonamentoId = abbonamentoId;
	}
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
	public AttivitaRequest(Integer id, String descrizione, Integer abbonamentoId) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.abbonamentoId = abbonamentoId;
	}

	
	
	

}
