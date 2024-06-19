package com.betacom.thread;

public abstract class Automobile {
	
	private String marca ;
	private String modello;
	private String targa;
	private Integer cilindrata;
	
	

	public Automobile(String marca, String modello, String targa, Integer cilindrata) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.cilindrata = cilindrata;
	}
	
	public abstract String getType();
	 
	public String getMessagge() {
		return "" + this + "Tipo: " + getType() + this.marca + "modello: " + this.modello +" cilindrata: " + this.cilindrata + " targa: " + this.targa;
	}

	@Override
	public String toString() {
		return "Automobile [marca=" + marca + ", modello=" + modello + ", targa=" + targa + ", cilindrata=" + cilindrata
				+ "]";
	}
	
	
	

}
