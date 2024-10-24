package com.betacom.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.sbb.pojo.MessageID;
import com.betacom.sbb.pojo.MessaggiInternational;

public interface IMessaggiInternationalRepository extends JpaRepository<MessaggiInternational, MessageID>{

}
