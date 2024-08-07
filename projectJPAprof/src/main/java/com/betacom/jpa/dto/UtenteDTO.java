package com.betacom.jpa.dto;

import com.betacom.jpa.util.Roles;

public class UtenteDTO {
	
	private String id;
	private String userName;
	private String pwd;
	private String role;
	
	
	public UtenteDTO(String id, String userName, String pwd, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.role = role;
	}

	
	public UtenteDTO() {
		super();
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
