package com.betacom.projectReflectoin;

public class MyClassReflection {
	private Integer id;
	private String desc;
	
	
	public MyClassReflection() {
	}
	
	public MyClassReflection(Integer id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
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
	@Override
	public String toString() {
		return "MyClassReflection [id=" + id + ", desc=" + desc + "]";
	}
	

}
