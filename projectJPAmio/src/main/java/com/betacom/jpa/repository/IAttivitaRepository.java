package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.Attivita;

public interface IAttivitaRepository extends JpaRepository<Attivita, Integer>{
	Optional<Attivita> findByDescrizione(String desc);

}
