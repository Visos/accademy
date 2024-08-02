package com.betacom.jpa.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "veicolo")
public class Veicolo {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name = "tipoAlimentazione")
	private TipoAlimentazione tipoAlimentazione;
	
	@ManyToOne
	@JoinColumn(name = "colore")
	private TipoColore colore;
	
	@ManyToOne
	@JoinColumn(name = "tipoVeicolo")
	private TipoVeicolo tipoVeicolo;
	
	@Column
	private Integer numeroRuote;
	
	@Column
	private Integer nPosti;
	
	@ManyToOne
	@JoinColumn(name = "marca")
	private TipoMarca marca;
	
	@OneToOne
	@JoinColumn(name = "id_moto",
			referencedColumnName = "id")
	private Moto moto;
	@OneToOne

	@JoinColumn(name = "id_bici",
			referencedColumnName = "id")
	private Bici bici;
	
	@OneToOne
	@JoinColumn(name = "id_macchina",
			referencedColumnName = "id")
	private Macchina macchina;
	
	
	
	

	public Veicolo(Integer id, TipoAlimentazione tipoAlimentazione, TipoColore colore, TipoVeicolo tipoVeicolo, Integer numeroRuote,
			Integer nPosti, TipoMarca marca) {
		super();
		Id = id;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.tipoVeicolo = tipoVeicolo;
		this.numeroRuote = numeroRuote;
		this.nPosti = nPosti;
		this.marca = marca;
	}


	public Veicolo() {
		super();
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public TipoAlimentazione getTipoAlimentazione() {
		return tipoAlimentazione;
	}

	public void setTipoAlimentazione(TipoAlimentazione tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}

	public TipoColore getColore() {
		return colore;
	}

	public void setColore(TipoColore colore) {
		this.colore = colore;
	}

	public TipoVeicolo getTipoVeicolo() {
		return tipoVeicolo;
	}

	public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}

	public Integer getNumeroRuote() {
		return numeroRuote;
	}

	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}

	public Integer getnPosti() {
		return nPosti;
	}

	public void setnPosti(Integer nPosti) {
		this.nPosti = nPosti;
	}

	public TipoMarca getMarca() {
		return marca;
	}

	public void setMarca(TipoMarca marca) {
		this.marca = marca;
	}


	public Moto getMoto() {
		return moto;
	}


	public void setMoto(Moto moto) {
		this.moto = moto;
	}


	public Bici getBici() {
		return bici;
	}


	public void setBici(Bici bici) {
		this.bici = bici;
	}


	public Macchina getMacchina() {
		return macchina;
	}


	public void setMacchina(Macchina macchina) {
		this.macchina = macchina;
	}
	
	
	
	
	

}
