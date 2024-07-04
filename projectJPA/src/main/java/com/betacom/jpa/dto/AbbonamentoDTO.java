package com.betacom.jpa.dto;


public class AbbonamentoDTO {

	private Integer id;
	private String dataIscrizione;
	private Integer socioID;
	
	
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

	public AbbonamentoDTO(Integer id, String dataIscrizione, Integer socioID) {
		super();
		this.id = id;
		this.dataIscrizione = dataIscrizione;
		this.socioID = socioID;
	}

	public Integer getSocioID() {
		return socioID;
	}

	public void setSocioID(Integer socioID) {
		this.socioID = socioID;
	}

	public AbbonamentoDTO(){
		super();
	}

	@Override
	public String toString() {
		return "AbbonamentoDTO [id=" + id + ", dataIscrizione=" + dataIscrizione + "]";
	}
	
	

}
