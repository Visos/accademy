package com.betacom.objects;

public class Cliente {
	private  String nome;
	private String cognome;
	private int età;
	
	public Cliente (String nome, String cognome, Integer età) {
		this.nome = nome;
		this.cognome = cognome;
		this.età = età;
	}
	@Override
	public String toString() {
		return "[nome: "+ nome + " cognome: " + cognome + " età: " + età+ "]";
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
	public int getEtà() {
		return età;
	}
	public void setEtà(int età) {
		this.età = età;
	}
	
	
}
