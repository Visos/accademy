package com.betacom.jpa.pojo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "messaggi-international")
public class MessaggeInternational implements Serializable{
	@EmbeddedId
	private MessaggeID msgID;
	
	private String messaggio;
	
	
	
	public MessaggeInternational() {
		super();
	}


	public MessaggeInternational(MessaggeID msgID, String messaggio) {
		super();
		this.msgID = msgID;
		this.messaggio = messaggio;
	}

	public MessaggeID getMsgID() {
		return msgID;
	}

	public void setMsgID(MessaggeID msgID) {
		this.msgID = msgID;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(messaggio, msgID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessaggeInternational other = (MessaggeInternational) obj;
		return Objects.equals(messaggio, other.messaggio) && Objects.equals(msgID, other.msgID);
	}
	
	
	
	
}
