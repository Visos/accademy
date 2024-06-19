package com.betcacom.car.oggetti;

public class Bici extends Veicolo{
	private String tipoUso;
	private String sospensioni;
	private Boolean Cestino;
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
	public Boolean getCestino() {
		return Cestino;
	}
	public void setCestino(Boolean cestino) {
		Cestino = cestino;
	}
	public Boolean getPieghevole() {
		return pieghevole;
	}
	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}
	

}
