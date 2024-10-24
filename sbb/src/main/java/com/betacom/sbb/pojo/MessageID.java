package com.betacom.sbb.pojo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class MessageID implements Serializable{

	private String lang;
	private String code;
	
	public MessageID() {
		super();
	}
	public MessageID(String lang, String code) {
		super();
		this.lang = lang;
		this.code = code;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code, lang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageID other = (MessageID) obj;
		return Objects.equals(code, other.code) && Objects.equals(lang, other.lang);
	}
	
	
	
}
