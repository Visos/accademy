package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.Bici;

public class TipoAmmortizzatoreDTO {
	
	private Integer id;
	private String descrizione;
	private Integer bici;
	
	
	public TipoAmmortizzatoreDTO() {
		super();
	}

	
	
	public TipoAmmortizzatoreDTO(Integer id, String descrizione, Integer bici) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.bici = bici;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	

}
