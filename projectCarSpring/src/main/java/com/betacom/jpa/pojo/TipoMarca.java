package com.betacom.jpa.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "marca")
public class TipoMarca {
	@Id
	private Integer id;
	
	@Column(length = 50)
	private String descrizione;
	
	@OneToMany(mappedBy = "marca")
	private List<Veicolo> veicolo;

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

	public List<Veicolo> getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(List<Veicolo> veicolo) {
		this.veicolo = veicolo;
	}
	
	
	

}
