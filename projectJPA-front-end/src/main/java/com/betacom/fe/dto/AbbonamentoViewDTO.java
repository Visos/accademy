package com.betacom.fe.dto;

import java.util.List;

public class AbbonamentoViewDTO {
	private Integer id;
	private String dataIscrizione;
	private List<AttivitaDTO> attivita;
	
	
	public AbbonamentoViewDTO() {
		super();
	}
	
	public AbbonamentoViewDTO(Integer id, String dataIscrizione, List<AttivitaDTO> attivita) {
		super();
		this.id = id;
		this.dataIscrizione = dataIscrizione;
		this.attivita = attivita;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(String dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public List<AttivitaDTO> getAttivita() {
		return attivita;
	}
	public void setAttivita(List<AttivitaDTO> attivita) {
		this.attivita = attivita;
	}

}
