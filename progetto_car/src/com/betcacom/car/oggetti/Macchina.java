package com.betcacom.car.oggetti;

import java.util.Date;

public class Macchina extends Veicolo{
	private Integer numeroPorte;
	private String numerotarga;
	private Integer cc;

	

	public static Integer numeroErrori = 0;
	public static Integer numeroMacchina = 0;
	
	public static void statistiche() {
		System.out.printf("Macchine create = %d. macchine errate = %d \n", numeroMacchina, numeroErrori );
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
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
	}


	
	
	
	
}
