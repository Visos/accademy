package com.betacom.rest.comtroller.object;

public class RequestObject {
	
	private String azione;
	private String mode;
	private String nome;
	private String congnome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCongnome() {
		return congnome;
	}
	public void setCongnome(String congnome) {
		this.congnome = congnome;
	
	}
	
	public String getAzione() {
		return azione;
	}
	public void setAzione(String azione) {
		this.azione = azione;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	

}
