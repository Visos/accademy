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
	private Integer code;
	
	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "tipoAlimentazione")
	private List<Veicolo> veicoli;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Veicolo> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(List<Veicolo> veicoli) {
		this.veicoli = veicoli;
	}
	
	

}
