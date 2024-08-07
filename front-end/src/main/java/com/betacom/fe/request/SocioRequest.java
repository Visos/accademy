package com.betacom.fe.request;

public class SocioRequest {
	
	private Integer id;
	private String cognome;
	private String nome;
	private String cf;
	
	private String errorMSG;
	
	public SocioRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SocioRequest(Integer id, String cognome, String nome, String cf, String errorMSG) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.cf = cf;
		this.errorMSG = errorMSG;
	}
	public String getErrorMSG() {
		return errorMSG;
	}
	public void setErrorMSG(String errorMSG) {
		this.errorMSG = errorMSG;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}

}
