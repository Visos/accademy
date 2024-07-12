package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.TipoAlimentazione;

public interface ITipoAlimRepository extends JpaRepository<TipoAlimentazione, Integer>{

	Optional<TipoAlimentazione> findByDescrizione(String colore);

}
