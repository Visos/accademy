package com.betacom.fe.request;

import java.util.List;

public class AlimentazioneReq {

	private Integer id;
	private String desc;
	private Boolean forAuto;
	private Boolean forBici;
	private Boolean forMoto;
	private List<VeicoloReq> veicoli;
	
	public AlimentazioneReq() {
		super();
	}

	public AlimentazioneReq(String desc, Boolean forAuto, Boolean forBici, Boolean forMoto) {
		super();
		this.desc = desc;
		this.forAuto = forAuto;
		this.forBici = forBici;
		this.forMoto = forMoto;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Boolean getForAuto() {
		return forAuto;
	}

	public void setForAuto(Boolean forAuto) {
		this.forAuto = forAuto;
	}

	public Boolean getForBici() {
		return forBici;
	}

	public void setForBici(Boolean forBici) {
		this.forBici = forBici;
	}

	public Boolean getForMoto() {
		return forMoto;
	}

	public void setForMoto(Boolean forMoto) {
		this.forMoto = forMoto;
	}

	public List<VeicoloReq> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(List<VeicoloReq> veicoli) {
		this.veicoli = veicoli;
	} 
}
