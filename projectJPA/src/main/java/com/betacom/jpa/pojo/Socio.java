package com.betacom.jpa.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity
@Table(name="socio")
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	

	@Column(length = 50)
	private String cognome;
	
	@Column(length = 50)
	private String nome;
	
	@Column(name = "codice_fiscale",
			nullable = false,
			length = 17,
			unique = true
			)
	private String cFiscale;
	
	@OneToOne(mappedBy = "socio")
	private Certificato certificato;
	
	@OneToMany(
			mappedBy = "socio",
			fetch = FetchType.EAGER)		//eager: carica tutti gli abbonamenti associati - eager: li carica solo ru richiesta
	
	private List<Abbonamento> abbonamenti;
	
	
	
	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}
	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	public Certificato getCertificato() {
		return certificato;
	}
	public void setCertificato(Certificato certificato) {
		this.certificato = certificato;
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
