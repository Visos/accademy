package com.betacom.jpa.dto;

import com.betacom.jpa.pojo.TipoAlimentazione;
import com.betacom.jpa.pojo.TipoColore;
import com.betacom.jpa.pojo.TipoMarca;
import com.betacom.jpa.pojo.TipoVeicolo;


public class VeicoloDTO {
	
	private Integer Id;
	private TipoAlimentazione tipoAlimentazione;
	private TipoColore colore;
	private TipoVeicolo tipoVeicolo;
	private Integer numeroRuote;
	private Integer nPosti;
	private TipoMarca marca;
	
	
	
	public VeicoloDTO(Integer id, TipoAlimentazione tipoAlimentazione, TipoColore colore, TipoVeicolo tipoVeicolo,
			Integer numeroRuote, Integer nPosti, TipoMarca marca) {
		super();
		Id = id;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.tipoVeicolo = tipoVeicolo;
		this.numeroRuote = numeroRuote;
		this.nPosti = nPosti;
		this.marca = marca;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public TipoAlimentazione getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(TipoAlimentazione tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public TipoColore getColore() {
		return colore;
	}
	public void setColore(TipoColore colore) {
		this.colore = colore;
	}
	public TipoVeicolo getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
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
	public TipoMarca getMarca() {
		return marca;
	}
	public void setMarca(TipoMarca marca) {
		this.marca = marca;
	}
	
	
	

}
