package com.betacom.jpa.dto;


public class MacchinaViewDto {
	//macchina
	private Integer id;
	private Integer numeroPorte;
	private String numerotarga;
	private Integer idVeicolo;
	
	//veicolo
	private String tipoAlimentazione;
	private String colore;
	private String tipoVeicolo;
	private Integer numeroRuote;
	private Integer nPosti;
	private String marca;
	
	
	
	
	public MacchinaViewDto(Integer id, Integer numeroPorte, String numerotarga, Integer idVeicolo,
			String tipoAlimentazione, String colore, String tipoVeicolo, Integer numeroRuote, Integer nPosti,
			String marca) {
		super();
		this.id = id;
		this.numeroPorte = numeroPorte;
		this.numerotarga = numerotarga;
		this.idVeicolo = idVeicolo;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.tipoVeicolo = tipoVeicolo;
		this.numeroRuote = numeroRuote;
		this.nPosti = nPosti;
		this.marca = marca;
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
	public Integer getIdVeicolo() {
		return idVeicolo;
	}
	public void setIdVeicolo(Integer idVeicolo) {
		this.idVeicolo = idVeicolo;
	}
	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public Integer getNumeroRuote() {
		return numeroRuote;
	}
	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}
	public Integer getnPosti() {
		return nPosti;
	}
	public void setnPosti(Integer nPosti) {
		this.nPosti = nPosti;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "MacchinaViewDto [id=" + id + ", numeroPorte=" + numeroPorte + ", numerotarga=" + numerotarga
				+ ", idVeicolo=" + idVeicolo + ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore
				+ ", tipoVeicolo=" + tipoVeicolo + ", numeroRuote=" + numeroRuote + ", nPosti=" + nPosti + ", marca="
				+ marca + "]";
	}
	
	

}
