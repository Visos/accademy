package com.betacom.jpa.dto;

import java.util.List;

public class AttivitaViewDTO {
	private Integer id;
	private String  descrizione;
	List<AbbonamentoView2DTO> attivita;
	
	public AttivitaViewDTO() {
		super();
	}
	public AttivitaViewDTO(Integer id, String descrizione, List<AbbonamentoView2DTO> attivita) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.attivita = attivita;
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
	public List<AbbonamentoView2DTO> getAttivita() {
		return attivita;
	}
	public void setAttivita(List<AbbonamentoView2DTO> attivita) {
		this.attivita = attivita;
	}
}
