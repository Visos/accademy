package com.betacom.fe.request;

public class VeicoloReq {

	private Integer idVeicolo;
	private Integer numeroRuote;
	private Integer numeroPosti;
	private String alimentazione; 
	private String colore;
	private String marca;
	private String tipoVeicolo;
	private String errorMSG;
	
	public String getErrorMSG() {
		return errorMSG;
	}

	public void setErrorMSG(String errorMSG) {
		this.errorMSG = errorMSG;
	}

//	private AutoReq autoR;
//	private BiciReq biciR;
//	private MotoReq motoR;
	
	public VeicoloReq() {
		super();
	}

	public VeicoloReq(Integer numeroRuote, Integer numeroPosti, String alimentazione, String colore, String marca,
			String tipoVeicolo) {
		super();
		this.numeroRuote = numeroRuote;
		this.numeroPosti = numeroPosti;
		this.alimentazione = alimentazione;
		this.colore = colore;
		this.marca = marca;
		this.tipoVeicolo = tipoVeicolo;
	}

	public Integer getIdVeicolo() {
		return idVeicolo;
	}

	public void setIdVeicolo(Integer idVeicolo) {
		this.idVeicolo = idVeicolo;
	}

	public Integer getNumeroRuote() {
		return numeroRuote;
	}

	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}

	public Integer getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoVeicolo() {
		return tipoVeicolo;
	}

	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}

	@Override
	public String toString() {
		return "VeicoloReq [idVeicolo=" + idVeicolo + ", numeroRuote=" + numeroRuote + ", numeroPosti=" + numeroPosti
				+ ", alimentazione=" + alimentazione + ", colore=" + colore + ", marca=" + marca + ", tipoVeicolo="
				+ tipoVeicolo + ", errorMSG=" + errorMSG + "]";
	}
	


}
