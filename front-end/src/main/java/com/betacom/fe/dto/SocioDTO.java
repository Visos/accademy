package com.betacom.fe.dto;

import java.util.List;

public class SocioDTO {
	
	private Integer id;
	private String cognome;
	private String nome;
	private String cf;
	private Integer idCertificato;
	private String dataCertificato;
	private String tipoCertificato;
	private List<AbbonamentoDTO> abbonamento;
	
	public final List<AbbonamentoDTO> getAbbonamento() {
		return abbonamento;
	}


	public final void setAbbonamento(List<AbbonamentoDTO> abbonamento) {
		this.abbonamento = abbonamento;
	}
	
	public SocioDTO() {}

	public SocioDTO(Integer id, String cognome, String nome, String cf, Integer idCertificato, String dataCertificato,
			String tipoCertificato, List<AbbonamentoDTO> abbonamento) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.cf = cf;
		this.idCertificato = idCertificato;
		this.dataCertificato = dataCertificato;
		this.tipoCertificato = tipoCertificato;
		this.abbonamento = abbonamento;
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
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public Integer getIdCertificato() {
		return idCertificato;
	}
	public void setIdCertificato(Integer idCertificato) {
		this.idCertificato = idCertificato;
	}
	public String getDataCertificato() {
		return dataCertificato;
	}
	public void setDataCertificato(String dataCertificato) {
		this.dataCertificato = dataCertificato;
	}
	public String getTipoCertificato() {
		return tipoCertificato;
	}
	public void setTipoCertificato(String tipoCertificato) {
		this.tipoCertificato = tipoCertificato;
	}


	@Override
	public String toString() {
		return "SocioDTO [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", cf=" + cf + ", idCertificato="
				+ idCertificato + ", dataCertificato=" + dataCertificato + ", tipoCertificato=" + tipoCertificato + "]";
	}
	
	
	
}
