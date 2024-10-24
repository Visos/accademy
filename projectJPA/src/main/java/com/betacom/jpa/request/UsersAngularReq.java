package com.betacom.jpa.request;

public class UsersAngularReq {

	private Integer id;
	private String userName;
	private String pwd;
	private String role;	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UsersAngularReq(Integer id, String userName, String pwd, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.role = role;
	}
	
	public UsersAngularReq() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
