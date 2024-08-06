package com.betacom.fe.dto;

public class BiciViewDTO extends VeicoloViewDTO{

	private Integer biciID;
	private Boolean pedalataAssistita;
	private Boolean pieghevole;
	private Boolean ammortizzatore;
	
	public BiciViewDTO() {
		super();
	}

	public BiciViewDTO(Integer idVeicolo, Integer numeroRuote, Integer numeroPosti, String alimentazione, String colore,
			String marca, String tipo,
			Integer biciID, Boolean pedalataAssistita, Boolean pieghevole, Boolean ammortizzatore) {
		super(idVeicolo, numeroRuote, numeroPosti, alimentazione, colore, marca, tipo);
		this.biciID = biciID;
		this.pedalataAssistita = pedalataAssistita;
		this.pieghevole = pieghevole;
		this.ammortizzatore = ammortizzatore;
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

	public Integer getBiciID() {
		return biciID;
	}

	public void setBiciID(Integer biciID) {
		this.biciID = biciID;
	}
	
}
