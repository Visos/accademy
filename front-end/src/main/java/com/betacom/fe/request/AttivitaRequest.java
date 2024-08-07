package com.betacom.fe.request;



public class AttivitaRequest {
	
	private Integer id;
	private String descrizione;
	private Integer abbonamentoId;
	private String[] attivita;
	private Integer socioID;
	private String errorMSG;
	
	public String getErrorMSG() {
		return errorMSG;
	}
	public void setErrorMSG(String errorMSG) {
		this.errorMSG = errorMSG;
	}
	public Integer getSocioID() {
		return socioID;
	}
	public void setSocioID(Integer socioID) {
		this.socioID = socioID;
	}
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
	

}
