package com.betacom.fe.dto;

public class AbbonamentoView2DTO {
	private Integer id;
	private String dataIscrizione;
	private Integer socioID;
	private String cognome;
	private String nome;
	
	public AbbonamentoView2DTO() {
		super();
	}
	public AbbonamentoView2DTO(Integer id, String dataIscrizione, Integer socioID, String cognome, String nome) {
		super();
		this.id = id;
		this.dataIscrizione = dataIscrizione;
		this.socioID = socioID;
		this.cognome = cognome;
		this.nome = nome;
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
	public Integer getSocioID() {
		return socioID;
	}
	public void setSocioID(Integer socioID) {
		this.socioID = socioID;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
