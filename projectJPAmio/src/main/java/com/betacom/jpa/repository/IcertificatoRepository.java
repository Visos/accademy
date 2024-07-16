package com.betacom.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.pojo.Certificato;

@Repository
public interface IcertificatoRepository extends JpaRepository<Certificato, Integer>{

}
