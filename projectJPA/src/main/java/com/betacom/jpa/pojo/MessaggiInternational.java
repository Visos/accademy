package com.betacom.jpa.pojo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="messaggi-international")
public class MessaggiInternational implements Serializable{
	@EmbeddedId
	private MessageID msgID;
	
	private String messagio;

	public MessageID getMsgID() {
		return msgID;
	}

	public void setMsgID(MessageID msgID) {
		this.msgID = msgID;
	}

	public String getMessagio() {
		return messagio;
	}

	public void setMessagio(String messagio) {
		this.messagio = messagio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(messagio, msgID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessaggiInternational other = (MessaggiInternational) obj;
		return Objects.equals(messagio, other.messagio) && Objects.equals(msgID, other.msgID);
	}
}
