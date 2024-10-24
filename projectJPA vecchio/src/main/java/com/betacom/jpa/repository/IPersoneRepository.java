package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.Persone;

public interface IPersoneRepository extends JpaRepository<Persone, Integer>{

	Optional<Persone> findByCognomeandNome(String nome, String cognome);
}
