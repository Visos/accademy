package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.request.AbbonamentoReq;

public class AttivitaViewDTO {

	private Integer id;
	private String descrizione;
	private List<AbbonamentoReq> abbonamenti;
	
	public AttivitaViewDTO() {
		super();
	}

	public AttivitaViewDTO(Integer id, String descrizione, List<AbbonamentoReq> abbonamenti) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.abbonamenti = abbonamenti;
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

	public List<AbbonamentoReq> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<AbbonamentoReq> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	
	
}
