package com.betacom.sbb.dto;

public class SocioDTO {
	private Integer id;
	private String cognome;
	private String nome;
	private String cFiscale;
	private Integer idCertificato;
	private String dataCerticicato;
	private String tipoCertificato;
	
	public SocioDTO() {
		super();
	}

	public SocioDTO(Integer id, String cognome, String nome, String cFiscale, Integer idCertificato,
			String dataCerticicato, String tipoCertificato) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.cFiscale = cFiscale;
		this.idCertificato = idCertificato;
		this.dataCerticicato = dataCerticicato;
		this.tipoCertificato = tipoCertificato;
	}	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getcFiscale() {
		return cFiscale;
	}
	public void setcFiscale(String cFiscale) {
		this.cFiscale = cFiscale;
	}
	public Integer getIdCertificato() {
		return idCertificato;
	}
	public void setIdCertificato(Integer idCertificato) {
		this.idCertificato = idCertificato;
	}
	public String getDataCerticicato() {
		return dataCerticicato;
	}
	public void setDataCerticicato(String dataCerticicato) {
		this.dataCerticicato = dataCerticicato;
	}
	public String getTipoCertificato() {
		return tipoCertificato;
	}
	public void setTipoCertificato(String tipoCertificato) {
		this.tipoCertificato = tipoCertificato;
	}
	@Override
	public String toString() {
		return "SocioDTO [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", cFiscale=" + cFiscale
				+ ", idCertificato=" + idCertificato + ", dataCerticicato=" + dataCerticicato + ", tipoCertificato="
				+ tipoCertificato + "]";
	}

	public String withDelimiter() {
		return id + "," + cognome + "," + nome + "," + cFiscale
		+ "," + idCertificato + "," + dataCerticicato + "," + tipoCertificato;
	}
}
