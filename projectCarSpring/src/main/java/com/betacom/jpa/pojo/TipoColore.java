package com.betacom.jpa.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "colore")
public class TipoColore {
	
	@Id
	private Integer code;
	
	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "colore")
	private List<Veicolo> veicoli;

}
