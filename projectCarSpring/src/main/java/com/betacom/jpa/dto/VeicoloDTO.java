package com.betacom.jpa.dto;

import com.betacom.jpa.pojo.TipoAlimentazione;
import com.betacom.jpa.pojo.TipoColore;
import com.betacom.jpa.pojo.TipoMarca;
import com.betacom.jpa.pojo.TipoVeicolo;


public class VeicoloDTO {
	
	private Integer Id;
	private String tipoAlimentazione;
	private String colore;
	private String tipoVeicolo;
	private Integer numeroRuote;
	private Integer nPosti;
	private String marca;
	private Integer idBici;
	private Integer idMacchina;
	private Integer idMoto;

	
	
	

	public VeicoloDTO() {
		super();
		}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	
	
	

}
