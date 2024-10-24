package com.betacom.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.betacom.jpa.pojo.MessageID;
import com.betacom.jpa.pojo.MessaggiInternational;

public interface IMessaggiInternationalRepository extends JpaRepository<MessaggiInternational, MessageID>{

}
