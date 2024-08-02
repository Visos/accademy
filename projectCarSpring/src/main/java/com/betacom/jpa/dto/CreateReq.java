package com.betacom.jpa.dto;

public class CreateReq<T> {
	private T tipo;
	private VeicoloDTO veicolo;
	
	
	public CreateReq() {
		super();
	}
	
	public CreateReq(T tipo, VeicoloDTO veicolo) {
		super();
		this.tipo = tipo;
		this.veicolo = veicolo;
	}
	public T getTipo() {
		return tipo;
	}
	public void setTipo(T macchina) {
		this.tipo = macchina;
	}
	public VeicoloDTO getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(VeicoloDTO veicolo) {
		this.veicolo = veicolo;
	}
	
	

}
