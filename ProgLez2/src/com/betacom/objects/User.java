package com.betacom.objects;

public class User{

	String nome;
	String cognome;
	Boolean sesso;
	Integer tipo = 0;
	
	public User() {
	}
	public User(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	@Override
	public String toString() {
		return "[ nome=" + nome + " cognome=" + cognome +" ]";
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
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
}
