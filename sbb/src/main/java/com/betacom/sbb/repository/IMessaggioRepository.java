package com.betacom.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.sbb.pojo.Messaggi;

@Repository
public interface IMessaggioRepository extends JpaRepository<Messaggi, String>{

}
