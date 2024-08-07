package com.betacom.fe.dto;



public class AttivitaDTO {
	private Integer id;
	private String descrizione;
	
	

	public AttivitaDTO(Integer id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public AttivitaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public  void setId(Integer id) {
		this.id = id;
	}
	public  String getDescrizione() {
		return descrizione;
	}
	public  void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	

}
