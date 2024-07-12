package com.betacom.jpa.dto;

import com.betacom.jpa.pojo.Veicolo;



public class MacchinaDTO {
	
	private Integer id;
	private Integer numeroPorte;
	private String numerotarga;
	private Veicolo veicolo;
	
	
	
	
	public MacchinaDTO(Integer id, Integer numeroPorte, String numerotarga, Veicolo veicolo) {
		super();
		this.id = id;
		this.numeroPorte = numeroPorte;
		this.numerotarga = numerotarga;
		this.veicolo = veicolo;
	}
	public MacchinaDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Veicolo getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	@Override
	public String toString() {
		return "MacchinaDTO [id=" + id + ", numeroPorte=" + numeroPorte + ", numerotarga=" + numerotarga + ", veicolo="
				+ veicolo.getId() + "]";
	}

	
	
	
}
