package com.betacom.jpa.dto;

public class CertificatoViewDto {
	
	private Integer id;
	private String tipo;
	private String dataCertificato;
	
	public CertificatoViewDto() {
	super();
}

	public CertificatoViewDto(Integer id, String tipo, String dataCertificato) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dataCertificato = dataCertificato;
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
	
	
	
	
	

}
