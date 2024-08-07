package com.betacom.fe.dto;
//le view rappresentano ciò che si vuole mostrare al client, evitando ripetizioni
import java.util.List;

public class SocioViewDTO {
	
	private Integer id;
	private String cognome;
	private String nome;
	private String cf;

	private CertificatoViewDTO certificato;
	private List<AbbonamentoViewDTO> abbonamenti;
	
	
	
	@Override
	public String toString() {
		return "SocioViewDTO [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", cf=" + cf + ", certificato="
				+ certificato + ", abbonamenti=" + abbonamenti + "]";
	}
	public CertificatoViewDTO getCertificato() {
		return certificato;
	}
	public void setCertificato(CertificatoViewDTO certificato) {
		this.certificato = certificato;
	}
	
	public SocioViewDTO() {
		super();
	}
	
	public SocioViewDTO(Integer id, String cognome, String nome, String cf, CertificatoViewDTO certificato,
			List<AbbonamentoViewDTO> abbonamenti) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.cf = cf;
		this.certificato = certificato;
		this.abbonamenti = abbonamenti;
	}
	
	public List<AbbonamentoViewDTO> getAbbonamenti() {
		return abbonamenti;
	}
	public void setAbbonamenti(List<AbbonamentoViewDTO> abbonamenti) {
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
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}

}
