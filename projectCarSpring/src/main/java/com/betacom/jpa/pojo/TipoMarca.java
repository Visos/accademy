package com.betacom.jpa.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private Veicolo veicolo;

}
