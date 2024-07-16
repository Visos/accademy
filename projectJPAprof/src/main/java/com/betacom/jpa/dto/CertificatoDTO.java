package com.betacom.jpa.dto;

public class CertificatoDTO {
	private Integer id;
	private String tipo; // false normale , true agonistico
	private String dataCertificato;
	private Integer socioID;
	private String  socioCognome;
	private String 	socioNome;
	private String  socioCFiscale;

	
	
	public CertificatoDTO() {
		super();
	}

	public CertificatoDTO(Integer id, String tipo, String dataCertificato, Integer socioID, String socioCognome,
			String socioNome, String socioCFiscale) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dataCertificato = dataCertificato;
		this.socioID = socioID;
		this.socioCognome = socioCognome;
		this.socioNome = socioNome;
		this.socioCFiscale = socioCFiscale;
	}


	@Override
	public String toString() {
		return "CertificatoDTO [id=" + id + ", tipo=" + tipo + ", dataCertificato=" + dataCertificato + ", socioID="
				+ socioID + ", SocioCognome=" + socioCognome + ", SocioNome=" + socioNome + ", SocioCFiscale="
				+ socioCFiscale + "]";
	}

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

	public String getSocioCognome() {
		return socioCognome;
	}

	public void setSocioCognome(String socioCognome) {
		this.socioCognome = socioCognome;
	}

	public String getSocioNome() {
		return socioNome;
	}

	public void setSocioNome(String socioNome) {
		this.socioNome = socioNome;
	}

	public String getSocioCFiscale() {
		return socioCFiscale;
	}

	public void setSocioCFiscale(String socioCFiscale) {
		this.socioCFiscale = socioCFiscale;
	}



}
