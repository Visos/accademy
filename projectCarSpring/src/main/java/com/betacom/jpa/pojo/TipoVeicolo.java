package com.betacom.jpa.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_veicolo")
public class TipoVeicolo {
	
	@Id
	private String id;
	
	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "tipoVeicolo")
	private List<Veicolo> veicoli;

}
