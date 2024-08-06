package com.betacom.fe.dto;

import java.util.List;

public class ColoreViewDTO {

	private String desc;
	private List<VeicoloViewDTO> veicoli;
	
	public ColoreViewDTO() {
		super();
	}
	
	public ColoreViewDTO(String desc) {
		super();
		this.desc = desc;
	}

	public ColoreViewDTO(String desc, List<VeicoloViewDTO> veicoli) {
		super();
		this.desc = desc;
		this.veicoli = veicoli;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<VeicoloViewDTO> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(List<VeicoloViewDTO> veicoli) {
		this.veicoli = veicoli;
	}
	
	
}
