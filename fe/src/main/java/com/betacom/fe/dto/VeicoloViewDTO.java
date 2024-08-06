package com.betacom.fe.dto;

public class VeicoloViewDTO{

	private Integer idVeicolo;
	private Integer numeroRuote;
	private Integer numeroPosti;
	private String alimentazione; 
	private String colore;
	private String marca;
	private String tipo;
	
	
	public VeicoloViewDTO() {
		super();
	}

	public VeicoloViewDTO(Integer idVeicolo, Integer numeroRuote, Integer numeroPosti, String alimentazione,
			String colore, String marca, String tipo) {
		super();
		this.idVeicolo = idVeicolo;
		this.numeroRuote = numeroRuote;
		this.numeroPosti = numeroPosti;
		this.alimentazione = alimentazione;
		this.colore = colore;
		this.marca = marca;
		this.tipo = tipo;
	}
	
	

	public Integer getIdVeicolo() {
		return idVeicolo;
	}

	public void setIdVeicolo(Integer idVeicolo) {
		this.idVeicolo = idVeicolo;
	}

	public Integer getNumeroRuote() {
		return numeroRuote;
	}

	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}
	

	public Integer getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
