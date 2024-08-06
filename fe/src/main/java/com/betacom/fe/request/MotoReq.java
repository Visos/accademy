package com.betacom.fe.request;

public class MotoReq extends VeicoloReq{

	private Integer id;
	private String targa;
	private Integer cilindrata;
	private Integer kilowatt;
	private String errorMsg;
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public MotoReq() {
		super();
	}

	public MotoReq(Integer numeroRuote, Integer numeroPosti, String alimentazione, String colore, String marca,
			String tipoVeicolo, String targa, Integer cilindrata, Integer kilowatt) {
		super(numeroRuote, numeroPosti, alimentazione, colore, marca, tipoVeicolo);
		this.targa = targa;
		this.cilindrata = cilindrata;
		this.kilowatt = kilowatt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
