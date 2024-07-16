package com.betacom.jpa.request;

import java.util.Arrays;

public class AbbonamentoAttivitaReq {
	private Integer abbonamentoID;
	private String[] attivita;
	
	public AbbonamentoAttivitaReq() {
		super();
	}
	public AbbonamentoAttivitaReq(Integer abbonamentoID, String[] attivita) {
		super();
		this.abbonamentoID = abbonamentoID;
		this.attivita = attivita;
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
	@Override
	public String toString() {
		return "AbbonamentoAttivitaReq [abbonamentoID=" + abbonamentoID + ", attivita=" + Arrays.toString(attivita)
				+ "]";
	}
	
}
