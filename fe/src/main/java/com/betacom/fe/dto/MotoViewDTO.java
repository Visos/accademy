package com.betacom.fe.dto;

public class MotoViewDTO extends VeicoloViewDTO{

	private Integer motoID;
	private String targa;
	private Integer cilindrata;
	private Integer kilowatt;
	
	public MotoViewDTO() {
		super();
	}
	

	public MotoViewDTO(Integer idVeicolo, Integer numeroRuote, Integer numeroPosti, String alimentazione, String colore,
			String marca, String tipo,
			Integer motoID, String targa, Integer cilindrata, Integer kilowatt) {
		super(idVeicolo, numeroRuote, numeroPosti, alimentazione, colore, marca, tipo);
		this.motoID = motoID;
		this.targa = targa;
		this.cilindrata = cilindrata;
		this.kilowatt = kilowatt;
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


	public Integer getMotoID() {
		return motoID;
	}


	public void setMotoID(Integer motoID) {
		this.motoID = motoID;
	}
}
