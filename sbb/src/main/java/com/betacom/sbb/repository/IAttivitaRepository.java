package com.betacom.sbb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.sbb.pojo.Attivita;

public interface IAttivitaRepository extends JpaRepository<Attivita, Integer>{
	Optional<Attivita> findByDescrizione(String desc);
}
