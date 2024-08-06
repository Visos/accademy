package com.betacom.fe.request;

import java.util.List;

public class ColoreReq {

	private Integer id;
	private String desc;
	private List<VeicoloReq> veicoli;
	
	public ColoreReq() {
		super();
	}

	public ColoreReq(Integer id, String desc, List<VeicoloReq> veicoli) {
		super();
		this.id = id;
		this.desc = desc;
		this.veicoli = veicoli;
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

	public List<VeicoloReq> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(List<VeicoloReq> veicoli) {
		this.veicoli = veicoli;
	}
	
	
}
