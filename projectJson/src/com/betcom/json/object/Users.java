package com.betcom.json.object;

import java.util.Date;

public class Users{

	String nome;
	String cognome;
	Boolean sesso;
	Date dataNascita;
	
	

	public Users(String nome, String cognome, Date dataNascita, Boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}
	
	public String toString1() {
		return "[ nome: " + nome + ", cognome: " + cognome + ", data di nascita: " + dataNascita + "]";
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
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

