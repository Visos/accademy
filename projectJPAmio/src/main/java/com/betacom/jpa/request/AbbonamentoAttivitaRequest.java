package com.betacom.jpa.request;

public class AbbonamentoAttivitaRequest {
	private Integer abboamentoId;
	private String[] attivita;
	
	
	

	public AbbonamentoAttivitaRequest(Integer abboamentoId, String[] attivita) {
		super();
		this.abboamentoId = abboamentoId;
		this.attivita = attivita;
	}
	public Integer getAbboamentoId() {
		return abboamentoId;
	}
	public void setAbboamentoId(Integer abboamentoId) {
		this.abboamentoId = abboamentoId;
	}
	public String[] getAttivita() {
		return attivita;
	}
	public void setAttivita(String[] attivita) {
		this.attivita = attivita;
	}
	
	
	
	

}
