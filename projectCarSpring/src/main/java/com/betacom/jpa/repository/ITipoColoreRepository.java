package com.betacom.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.TipoColore;
import com.betacom.jpa.pojo.Veicolo;

public interface ITipoColoreRepository extends JpaRepository<TipoColore, Integer>{
	Optional<TipoColore> findByDescrizione(String colore);
}
