package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.Veicolo;

public class BiciViewDto {
	
	private Integer id;
	private String tipoUso;
	private Boolean pieghevole;
	private List<TipoAmmortizzatoreDTO> ammortizzatori;
	private Integer idVeicolo;
	
	
	//veicolo
	private String tipoAlimentazione;
	private String colore;
	private String tipoVeicolo;
	private Integer numeroRuote;
	private Integer nPosti;
	private String marca;
	
	
	

	public List<TipoAmmortizzatoreDTO> getAmmortizzatori() {
		return ammortizzatori;
	}
	public void setAmmortizzatori(List<TipoAmmortizzatoreDTO> ammortizzatori) {
		this.ammortizzatori = ammortizzatori;
	}
	public BiciViewDto(Integer id, String tipoUso, Boolean pieghevole, List<TipoAmmortizzatoreDTO> ammortizzatori,
			Integer idVeicolo, String tipoAlimentazione, String colore, String tipoVeicolo, Integer numeroRuote,
			Integer nPosti, String marca) {
		super();
		this.id = id;
		this.tipoUso = tipoUso;
		this.pieghevole = pieghevole;
		this.ammortizzatori = ammortizzatori;
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
	public String getTipoUso() {
		return tipoUso;
	}
	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}
	public Boolean getPieghevole() {
		return pieghevole;
	}
	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
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
		return "BiciViewDto [id=" + id + ", tipoUso=" + tipoUso + ", pieghevole=" + pieghevole + ", idVeicolo="
				+ idVeicolo + ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore + ", tipoVeicolo="
				+ tipoVeicolo + ", numeroRuote=" + numeroRuote + ", nPosti=" + nPosti + ", marca=" + marca + "]";
	}
	
	

}
