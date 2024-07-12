package com.betacom.jpa.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "macchina")
public class Macchina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer numeroPorte;
	
	@Column(nullable = false, unique = true)
	private String numerotarga;

	@OneToOne(mappedBy = "macchina")
	private Veicolo veicolo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

	public String getNumerotarga() {
		return numerotarga;
	}

	public void setNumerotarga(String numerotarga) {
		this.numerotarga = numerotarga;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
	
	
	
}
