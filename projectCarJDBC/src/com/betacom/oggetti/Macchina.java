package com.betacom.oggetti;

import java.util.Date;

public class Macchina extends Veicolo{
	

	private Integer numeroPorte;
	private String numerotarga;

	

	
	
	public Macchina(Integer id, Integer tipoAlimentazione, Integer colore, String tipoVeicolo, Integer numeroRuote,Integer nPosti, Integer marca, Integer numeroPorte, String numerotarga) {
		super(id, tipoAlimentazione, colore, tipoVeicolo, numeroRuote, nPosti, marca);
		this.numeroPorte = numeroPorte;
		this.numerotarga = numerotarga;
	}

	@Override
	public String toString() {
		String a = super.toString();
		return  "Macchina [ "+ a + "numeroPorte=" + numeroPorte + ", numerotarga=" + numerotarga + "]";
	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}
	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}
	public String getNumerotarga() {
		return numerotarga;
	}
	public void setNumerotarga(String numerotarga) {
		this.numerotarga = numerotarga;
	}



	
	
	
	
}
