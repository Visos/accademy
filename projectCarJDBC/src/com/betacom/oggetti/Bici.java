package com.betacom.oggetti;

public class Bici extends Veicolo{
	

	public Bici(Integer id, Integer tipoAlimentazione, Integer colore, String tipoVeicolo, Integer numeroRuote,
			Integer nPosti, Integer marca, String tipoUso, String sospensioni, Boolean pieghevole) {
		super(id, tipoAlimentazione, colore, tipoVeicolo, numeroRuote, nPosti, marca);
		this.tipoUso = tipoUso;
		this.sospensioni = sospensioni;
		this.pieghevole = pieghevole;
	}
	private String tipoUso;
	private String sospensioni;
	private Boolean pieghevole;
	
	
	
	
	public String getTipoUso() {
		return tipoUso;
	}
	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}
	public String getSospensioni() {
		return sospensioni;
	}
	public void setSospensioni(String sospensioni) {
		this.sospensioni = sospensioni;
	}

	public Boolean getPieghevole() {
		return pieghevole;
	}
	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}
	

}
