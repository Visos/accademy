package com.betacom.fe.request;

import java.util.List;

public class AmmortizzatoreReq {

	private Integer id;
	private String desc;
	private List<BiciReq> bici;
	
	public AmmortizzatoreReq() {
		super();
	}

	public AmmortizzatoreReq(Integer id, String desc, List<BiciReq> bici) {
		super();
		this.id = id;
		this.desc = desc;
		this.bici = bici;
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

	public List<BiciReq> getBici() {
		return bici;
	}

	public void setBici(List<BiciReq> bici) {
		this.bici = bici;
	}
	
	
}
