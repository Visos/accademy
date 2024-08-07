package com.betacom.fe.request;

public class AttivitaReq {
    private Integer id;
	private String  descrizione;
	private Integer abbonamentoID;
	private Integer socioID;
	private String[] attivita;
	private String errorMsg;

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
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
}
