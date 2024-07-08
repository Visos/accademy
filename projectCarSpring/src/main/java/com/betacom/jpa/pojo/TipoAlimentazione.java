package com.betacom.jpa.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_alimentazione")
public class TipoAlimentazione {
	
	
	@Id
	private String code;
	
	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "tipoAlimentazione")
	private List<Veicolo> veicoli;

}
