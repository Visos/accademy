package com.betacom.object;

public class User {
	String nome;
	String cognome;
	Boolean sesso;
	Integer tipo;
	
	
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public User(String nome, String cognome, Boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
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
	public Boolean getSesso() {
		return sesso;
	}
	public void setSesso(Boolean sesso) {
		this.sesso = sesso;
	}

	
	

}
