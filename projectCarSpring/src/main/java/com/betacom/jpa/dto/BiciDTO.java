package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.TipoAmmortizzatore;
import com.betacom.jpa.pojo.Veicolo;


public class BiciDTO {
	
	private Integer id;
	
	private String tipoUso;
		
	private Boolean pieghevole;
	
	private Integer veicolo;
	
	private List<TipoAmmortizzatoreDTO> ammortizzatore;
	
	
	@Override
	public String toString() {
		return "BiciDTO [id=" + id + ", tipoUso=" + tipoUso + ", pieghevole=" + pieghevole + ", veicolo=" + veicolo
				+ ", ammortizzatore=" + ammortizzatore + "]";
	}

	public BiciDTO(Integer id, String tipoUso, Boolean pieghevole, Integer veicolo,
			List<TipoAmmortizzatoreDTO> ammortizzatore) {
		super();
		this.id = id;
		this.tipoUso = tipoUso;
		this.pieghevole = pieghevole;
		this.veicolo = veicolo;
		this.ammortizzatore = ammortizzatore;
	}

	public List<TipoAmmortizzatoreDTO> getAmmortizzatore() {
		return ammortizzatore;
	}

	public void setAmmortizzatore(List<TipoAmmortizzatoreDTO> ammortizzatore) {
		this.ammortizzatore = ammortizzatore;
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

	public Integer getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Integer veicolo) {
		this.veicolo = veicolo;
	}
	
	

}
