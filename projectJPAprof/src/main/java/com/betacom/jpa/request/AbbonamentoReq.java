package com.betacom.jpa.request;

import com.betacom.jpa.pojo.Socio;

public class AbbonamentoReq {
	private Integer id;
	private String dataIscrizione;
	private Integer socioID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(String dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}

	
	
	
	public Integer getSocioID() {
		return socioID;
	}
	public void setSocioID(Integer socioID) {
		this.socioID = socioID;
	}
	@Override
	public String toString() {
		return "AbbonamentoReq [id=" + id + ", dataIscrizione=" + dataIscrizione + ", socioId=" + socioID+ "]";
	}
	
	

	
	
	

}
