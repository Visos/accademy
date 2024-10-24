package com.betacom.jpa.request;

public class CertificatoReq {
	private Integer id;
	private String tipo; // false normale , true agonistico
	private String dataCertificato;
	private Integer socioID;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDataCertificato() {
		return dataCertificato;
	}
	public void setDataCertificato(String dataCertificato) {
		this.dataCertificato = dataCertificato;
	}
	public Integer getSocioID() {
		return socioID;
	}
	public void setSocioID(Integer socioID) {
		this.socioID = socioID;
	}

}
