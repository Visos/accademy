package com.betacom.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.pojo.Messaggi;

@Repository
public interface IMessaggioRepository extends JpaRepository<Messaggi, String> {

}
