package com.betacom.oggetti;



public class Moto{

	private String Targa;
	private Integer cc;
	

	
	
	public Moto(String targa, Integer cc) {
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
