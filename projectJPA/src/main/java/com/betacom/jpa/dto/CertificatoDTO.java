package com.betacom.jpa.dto;


public class CertificatoDTO {


	private Integer id;
	private String tipo;
	private String dataCertificato;
	private Integer socioId;
	private String socioNome;
	private String socioCognome;
	private String cFiscale;

	
	

	public String getSocioNome() {
		return socioNome;
	}

	public void setSocioNome(String socioNome) {
		this.socioNome = socioNome;
	}

	public String getSocioCognome() {
		return socioCognome;
	}

	public void setSocioCognome(String socioCognome) {
		this.socioCognome = socioCognome;
	}

	public String getcFiscale() {
		return cFiscale;
	}

	public void setcFiscale(String cFiscale) {
		this.cFiscale = cFiscale;
	}



	public CertificatoDTO(Integer id, String tipo, String dataCertificato, Integer socioId, String socioNome,
			String socioCognome, String cFiscale) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dataCertificato = dataCertificato;
		this.socioId = socioId;
		this.socioNome = socioNome;
		this.socioCognome = socioCognome;
		this.cFiscale = cFiscale;
	}

	public CertificatoDTO() {
		super();
	}
	
	public String getTipo() {
		return tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String isTipo() {
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

	@Override
	public String toString() {
		return "CertificatoDTO [id=" + id + ", tipo=" + tipo + ", dataCertificato=" + dataCertificato + ", socioId="
				+ socioId + ", socioNome=" + socioNome + ", socioCognome=" + socioCognome + ", cFiscale=" + cFiscale
				+ "]";
	}

	public Integer getSocioId() {
		return socioId;
	}

	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}
	
	


}
