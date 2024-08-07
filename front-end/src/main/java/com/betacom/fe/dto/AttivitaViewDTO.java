package com.betacom.fe.dto;

import java.util.List;

public class AttivitaViewDTO {
	
	private Integer id;
	private String descrizione;
	private List<AbbonamentoDTO> abbonamenti;

	
	public AttivitaViewDTO() {
		super();
	}
	public AttivitaViewDTO(Integer id, String descrizione, List<AbbonamentoDTO> abbonamenti) {
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
	public List<AbbonamentoDTO> getAbbonamenti() {
		return abbonamenti;
	}
	public void setAbbonamenti(List<AbbonamentoDTO> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	

}
