package com.betacom.sbb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.sbb.pojo.Persone;

public interface IPersoneRepository extends JpaRepository<Persone, Integer>{

    Optional<Persone> findByCognomeAndNome(String cognome, String nome);
}
