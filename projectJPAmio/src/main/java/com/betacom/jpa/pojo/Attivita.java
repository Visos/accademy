package com.betacom.jpa.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attivita")
public class Attivita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50,
			name = "descrizione_attivita",
			nullable = false)
	private String descrizione;
	
	@ManyToMany(
			mappedBy = "attivita",
			fetch = FetchType.EAGER)
	private List<Abbonamento> abbonamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Abbonamento> getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(List<Abbonamento> abbonamento) {
		this.abbonamento = abbonamento;
	}
	
	
	
	
}
