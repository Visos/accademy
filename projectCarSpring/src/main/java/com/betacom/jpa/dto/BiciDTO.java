package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.TipoAmmortizzatore;
import com.betacom.jpa.pojo.Veicolo;


public class BiciDTO {
	
	private Integer id;
	
	private String tipoUso;
		
	private Boolean pieghevole;
	
	private Veicolo veicolo;
	
	public BiciDTO(Integer id, String tipoUso, Boolean pieghevole, Veicolo veicolo) {
		super();
		this.id = id;
		this.tipoUso = tipoUso;
		this.pieghevole = pieghevole;
		this.veicolo = veicolo;
	}

	@Override
	public String toString() {
		return "BiciDTO [id=" + id + ", tipoUso=" + tipoUso + ", pieghevole=" + pieghevole + ", veicolo=" + veicolo
				+ "]";
	}

	public BiciDTO() {
		super();
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

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
	

}
