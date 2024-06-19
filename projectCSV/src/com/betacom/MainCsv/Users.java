package com.betacom.MainCsv;

import java.util.Date;

public class Users{

	String nome;
	String cognome;
	Boolean sesso;
	String dataNascita;
	
	

	public Users(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}
	
	public String toString1() {
		return "[ nome: " + nome + ", cognome: " + cognome + ", data di nascita: " + dataNascita + "]";
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public Users() {
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

