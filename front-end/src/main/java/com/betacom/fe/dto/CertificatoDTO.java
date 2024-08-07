package com.betacom.fe.dto;

public class CertificatoDTO {

	private Integer id;
	private String tipo; //false normale, true agonistico
	private String dataCertificato;
	private Integer socioId;
	private String socioCognome;
	private String socioNome;
	private String socioCF;	
	
	@Override
	public String toString() {
		return "CertificatoDTO [id=" + id + ", tipo=" + tipo + ", dataCertificato=" + dataCertificato + ", socioId="
				+ socioId + ", socioCognome=" + socioCognome + ", socioNome=" + socioNome + ", socioCF=" + socioCF
				+ "]";
	}
	public CertificatoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificatoDTO(Integer id, String tipo, String dataCertificato, Integer socioId, String socioCognome,
			String socioNome, String socioCF) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dataCertificato = dataCertificato;
		this.socioId = socioId;
		this.socioCognome = socioCognome;
		this.socioNome = socioNome;
		this.socioCF = socioCF;
	}
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getTipo() {
		return tipo;
	}
	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public final String getDataCertificato() {
		return dataCertificato;
	}
	public final void setDataCertificato(String dataCertificato) {
		this.dataCertificato = dataCertificato;
	}
	public final Integer getSocioId() {
		return socioId;
	}
	public final void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}
	public final String getSocioCognome() {
		return socioCognome;
	}
	public final void setSocioCognome(String socioCognome) {
		this.socioCognome = socioCognome;
	}
	public final String getSocioNome() {
		return socioNome;
	}
	public final void setSocioNome(String socioNome) {
		this.socioNome = socioNome;
	}
	public final String getSocioCF() {
		return socioCF;
	}
	public final void setSocioCF(String socioCF) {
		this.socioCF = socioCF;
	}

	

	
	
}
