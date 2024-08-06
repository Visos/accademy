package com.betacom.fe.dto;

public class AutoViewDTO extends VeicoloViewDTO{

	private Integer autoID;
	private Integer numeroPorte;
	private String targa;
	private Integer cilindrata;
	private Integer kilowatt;
	
	public AutoViewDTO() {
		super();
	}

	public AutoViewDTO(Integer idVeicolo, Integer numeroRuote, Integer numeroPosti, String alimentazione, String colore, String marca,
			String tipo, Integer autoID, Integer numeroPorte, String targa, Integer cilindrata, 
			Integer kilowatt) {
		super(idVeicolo, numeroRuote, numeroPosti, alimentazione, colore, marca, tipo);
		this.autoID = autoID;
		this.numeroPorte = numeroPorte;
		this.targa = targa;
		this.cilindrata = cilindrata;
		this.kilowatt = kilowatt;
	}

	
	public Integer getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Integer getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	public Integer getKilowatt() {
		return kilowatt;
	}

	public void setKilowatt(Integer kilowatt) {
		this.kilowatt = kilowatt;
	}

	public Integer getAutoID() {
		return autoID;
	}

	public void setAutoID(Integer autoID) {
		this.autoID = autoID;
	}
}
