package com.betacom.jpa.dto;



public class VeicoloDTO {
	
	private Integer Id;
	private String tipoAlimentazione;
	private String colore;
	private String tipoVeicolo;
	private Integer numeroRuote;
	private Integer nPosti;
	private String marca;
	
	private BiciDTO bici;
	private MacchinaDTO macchina;
	private MotoDTO moto;

	
	public VeicoloDTO(Integer id, String tipoAlimentazione, String colore, String tipoVeicolo, Integer numeroRuote,Integer nPosti, String marca, BiciDTO bici, MacchinaDTO macchina, MotoDTO moto) {
		this.Id = id;
		this.tipoAlimentazione = tipoAlimentazione;
		this.colore = colore;
		this.tipoVeicolo = tipoVeicolo;
		this.numeroRuote = numeroRuote;
		this.nPosti = nPosti;
		this.marca = marca;
		this.bici = bici;
		this.macchina = macchina;
		this.moto = moto;
		}
	public VeicoloDTO() {
	super();
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "VeicoloDTO [Id=" + Id + ", tipoAlimentazione=" + tipoAlimentazione + ", colore=" + colore
				+ ", tipoVeicolo=" + tipoVeicolo + ", numeroRuote=" + numeroRuote + ", nPosti=" + nPosti + ", marca="
				+ marca + ", bici=" + bici + ", macchina=" + macchina + ", moto=" + moto + "]";
	}
	public BiciDTO getBici() {
		return bici;
	}
	public void setBici(BiciDTO bici) {
		this.bici = bici;
	}
	public MacchinaDTO getMacchina() {
		return macchina;
	}
	public void setMacchina(MacchinaDTO macchina) {
		this.macchina = macchina;
	}
	public MotoDTO getMoto() {
		return moto;
	}
	public void setMoto(MotoDTO moto) {
		this.moto = moto;
	}
	
	
	
	
	

}
