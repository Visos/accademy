package com.betacom.jpa.dto;

import com.betacom.jpa.pojo.Veicolo;

public class MotoDTO {
	
	private Integer id;
	
	private String Targa;
	
	private Integer cc;
	
	private Veicolo veicolo;
	
	
	public MotoDTO() {
		super();
	}
	
	public MotoDTO(Integer id, String targa, Integer cc, Veicolo veicolo) {
		super();
		this.id = id;
		Targa = targa;
		this.cc = cc;
		this.veicolo = veicolo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTarga() {
		return Targa;
	}

	public void setTarga(String targa) {
		Targa = targa;
	}

	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	@Override
	public String toString() {
		return "MotoDTO [id=" + id + ", Targa=" + Targa + ", cc=" + cc + ", veicolo=" + veicolo+ "]";
	}
	
	
	
	
	

}
