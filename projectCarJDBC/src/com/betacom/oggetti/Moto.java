package com.betacom.oggetti;

public class Moto extends Veicolo{

	private String Targa;
	private Integer cc;
	

	
	
	public Moto(Integer id, Integer tipoAlimentazione, Integer colore, String tipoVeicolo, Integer numeroRuote,
			Integer nPosti, Integer marca, String targa, Integer cc) {
		super(id, tipoAlimentazione, colore, tipoVeicolo, numeroRuote, nPosti, marca);
		Targa = targa;
		this.cc = cc;
	}
	public String getTarga() {
		return Targa;
	}
	public void setTarga(String numeroTarga) {
		this.Targa = numeroTarga;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}

	
	
}
