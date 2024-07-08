package com.betacom.jpa.pojo;

import java.util.List;
import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Fetch;

@Entity
@Table
public class TipoAmmortizzatore {
	
	@Id
	private Integer id;
	
	
	@Column(length = 50)
	private String descrizione;
	
	@ManyToMany(
			mappedBy = "sospensioni",
			fetch = FetchType.EAGER)
	private List<Bici> biciclette;

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

	public List<Bici> getBiciclette() {
		return biciclette;
	}

	public void setBiciclette(List<Bici> biciclette) {
		this.biciclette = biciclette;
	}
	
	
	

}
