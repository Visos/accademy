package com.betacom.fe.request;

public class BiciReq extends VeicoloReq{

	private Integer id;
	private Boolean pedalataAssistita;
	private Boolean pieghevole;
	private Boolean ammortizzatore;
	private String errorMsg;
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public BiciReq() {
		super();
	}

	public BiciReq(Integer numeroRuote, Integer numeroPosti, String alimentazione, String colore, String marca,
			String tipoVeicolo, Boolean pedalataAssistita, Boolean pieghevole, Boolean ammortizzatore) {
		super(numeroRuote, numeroPosti, alimentazione, colore, marca, tipoVeicolo);
		this.pedalataAssistita = pedalataAssistita;
		this.pieghevole = pieghevole;
		this.ammortizzatore = ammortizzatore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getPedalataAssistita() {
		return pedalataAssistita;
	}

	public void setPedalataAssistita(Boolean pedalataAssistita) {
		this.pedalataAssistita = pedalataAssistita;
	}

	public Boolean getPieghevole() {
		return pieghevole;
	}

	public void setPieghevole(Boolean pieghevole) {
		this.pieghevole = pieghevole;
	}

	public Boolean getAmmortizzatore() {
		return ammortizzatore;
	}

	public void setAmmortizzatore(Boolean ammortizzatore) {
		this.ammortizzatore = ammortizzatore;
	}
	
		
}
