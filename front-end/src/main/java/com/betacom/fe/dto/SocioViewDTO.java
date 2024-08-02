package com.betacom.fe.dto;

import java.util.List;

public class SocioViewDTO {
	private Integer id;
	private String cognome;
	private String nome;
	private String cFiscale;
	
	private CertificatoViewDTO certificato;
	private List<AbbonamentoViewDTO> abbonamenti;
	
	public SocioViewDTO() {
		super();
	}
	

	public SocioViewDTO(Integer id, String cognome, String nome, String cFiscale, CertificatoViewDTO certificato,
			List<AbbonamentoViewDTO> abbonamenti) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.cFiscale = cFiscale;
		this.certificato = certificato;
		this.abbonamenti = abbonamenti;
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
	public CertificatoViewDTO getCertificato() {
		return certificato;
	}
	public void setCertificato(CertificatoViewDTO certificato) {
		this.certificato = certificato;
	}

	public List<AbbonamentoViewDTO> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<AbbonamentoViewDTO> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}


	@Override
	public String toString() {
		return "SocioViewDTO [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", cFiscale=" + cFiscale
				+ ", certificato=" + certificato + ", abbonamenti=" + abbonamenti + "]";
	}


}
