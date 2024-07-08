package com.betacom.jpa.pojo;

import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "bici")
public class Bici{
	
	@Id
	private Integer id;
	
	@Column(length =50)
	private String tipoUso;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sospensioni",
				joinColumns = @JoinColumn(name = "bici_id"),
				inverseJoinColumns = @JoinColumn(name = "sospensioni"))
	private List<TipoAmmortizzatore> sospensioni;
	
	@Column
	private Boolean pieghevole;
	
	@OneToOne(mappedBy = "bici")
	private Veicolo veicolo;
	

	

	public Bici(Integer id,String tipoUso, List<TipoAmmortizzatore> sospensioni, Boolean pieghevole) {
		this.id = id;
		this.tipoUso = tipoUso;
		this.sospensioni = sospensioni;
		this.pieghevole = pieghevole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoUso() {
		return tipoUso;
	}

	public void setTipoUso(String tipoUso) {
		this.tipoUso = tipoUso;
	}

	public List<TipoAmmortizzatore> getSospensioni() {
		return sospensioni;
	}

	public void setSospensioni(List<TipoAmmortizzatore> sospensioni) {
		this.sospensioni = sospensioni;
	}

	public Boolean getPieghevole() {
		return pieghevole;
	}

	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}
	
	
	

}
