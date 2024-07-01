package com.betacom.oggetti;
//public abstract class Veicolo implements IGestioneVeicolo{
public abstract class Veicolo{
	
	private Integer Id;
	private Integer tipoAlimentazione;		//benzina, gas, gasolio, elettrica
	private Integer colore;
	private String tipoVeicolo;				//moto, truck, bici, vettura
	private Integer numeroRuote;
	private Integer nPosti;
	private Integer marca;
	
	


	@Override
	public String toString() {
		return "Id=" + Id + ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore
				+ ", tipoVeicolo=" + tipoVeicolo + ", numeroRuote=" + numeroRuote + ", nPosti=" + nPosti + ", marca="
				+ marca ;
	}
	public Veicolo(Integer id, Integer tipoAlimentazione, Integer colore, String tipoVeicolo, Integer numeroRuote,
			Integer nPosti, Integer marca) {
		super();
		Id = id;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.tipoVeicolo = tipoVeicolo;
		this.numeroRuote = numeroRuote;
		this.nPosti = nPosti;
		this.marca = marca;
	}
	public Integer getNumeroRuote() {
		return numeroRuote;
	}
	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}

	public Integer getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(Integer tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public Integer getColore() {
		return colore;
	}
	public void setColore(Integer colore) {
		this.colore = colore;
	}
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public Integer getMarca() {
		return marca;
	}
	public void setMarca(Integer marca) {
		this.marca = marca;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	


	public Integer getnPosti() {
		return nPosti;
	}
	public void setnPosti(Integer nPosti) {
		this.nPosti = nPosti;
	}

	
	

}
