package com.betacom.jpa.dto;

import com.betacom.jpa.pojo.Veicolo;

public class MotoViewDto {

	
	private Integer id;
	private String targa;
	private Integer cc;
	private Integer idVeicolo;

	private String tipoAlimentazione;
	private String colore;
	private String tipoVeicolo;
	private Integer numeroRuote;
	private Integer nPosti;
	private String marca;
	
	
	public MotoViewDto(Integer id, String targa, Integer cc, Integer idVeicolo, String tipoAlimentazione, String colore,
			String tipoVeicolo, Integer numeroRuote, Integer nPosti, String marca) {
		super();
		this.id = id;
		this.targa = targa;
		this.cc = cc;
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
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Integer getCc() {
		return cc;
	}
	public void setCc(Integer cc) {
		this.cc = cc;
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
		return "MotoViewDto [id=" + id + ", targa=" + targa + ", cc=" + cc + ", idVeicolo=" + idVeicolo
				+ ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore + ", tipoVeicolo=" + tipoVeicolo
				+ ", numeroRuote=" + numeroRuote + ", nPosti=" + nPosti + ", marca=" + marca + "]";
	}
	
	
	
}
