package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.TipoVeicolo;

public interface ITipoVeicoloRepository extends JpaRepository<TipoVeicolo, String>{

	Optional<TipoVeicolo> findByDescrizione(String colore);

}
