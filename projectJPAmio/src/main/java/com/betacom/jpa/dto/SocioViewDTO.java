package com.betacom.jpa.dto;

public class SocioViewDTO {
	
	private int id;
	private String nome;
	private String cognome;
	private String cFiscale;
	
	
	

	public SocioViewDTO(int id, String nome, String cognome, String cFiscale) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cFiscale = cFiscale;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getcFiscale() {
		return cFiscale;
	}
	public void setcFiscale(String cFiscale) {
		this.cFiscale = cFiscale;
	}
	
	

}
