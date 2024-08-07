package com.betacom.jpa.dto;

public class AttivitaDTO {
	private Integer id;
	private String  descrizione;
	
	public AttivitaDTO() {
		super();
	}
	
	public AttivitaDTO(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public AttivitaDTO(Integer id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "AttivitaDTO [id=" + id + ", descrizione=" + descrizione + "]";
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
