package com.betacom.jpa.dto;

import java.util.List;

import com.betacom.jpa.pojo.Abbonamento;

public class SocioDTO {


	private Integer Id;
	private String cognome;
	private String nome;
	private String cFiscale;
	private Integer idCertificato;
	private String dataCertificato;
	private String tipoCertificato;
	private List<AbbonamentoDTO> abbonamenti;
	
	


	public List<AbbonamentoDTO> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<AbbonamentoDTO> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}

	public SocioDTO() {
		super();
	}
	
	public SocioDTO(Integer id, String cognome, String nome, String cFiscale, Integer idCertificato, String dataCertificato, String tipoCertificato, List<AbbonamentoDTO> abbonamenti) {
		super();
		Id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.cFiscale = cFiscale;
		this.idCertificato = idCertificato;
		this.dataCertificato = dataCertificato;
		this.tipoCertificato = tipoCertificato;
		this.abbonamenti = abbonamenti;
	}
	
	
	@Override
	public String toString() {
		return "SocioDTO [Id=" + Id + ", cognome=" + cognome + ", nome=" + nome + ", cFiscale=" + cFiscale
				+ ", idCertificato=" + idCertificato + ", dataCertificato=" + dataCertificato + ", tipoCertificato="
				+ tipoCertificato + "]";
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

	public String getcFiscale() {
		return cFiscale;
	}
	public void setcFiscale(String cFiscale) {
		this.cFiscale = cFiscale;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	
	
}
