package com.betacom.fe.request;

public class TipoVeicoloReq {

	private Integer id;
	private String desc;
	private Boolean forAuto;
	private Boolean forBici;
	private Boolean forMoto;
	
	public TipoVeicoloReq() {
		super();
	}

	

	public TipoVeicoloReq(String desc, Boolean forAuto, Boolean forBici, Boolean forMoto) {
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
	
	
	
}
