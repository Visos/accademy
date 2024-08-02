package com.betacom.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.MessaggeID;
import com.betacom.jpa.pojo.MessaggeInternational;

public interface IMessaggeInternationalRepository extends JpaRepository<MessaggeInternational, MessaggeID>{

}
