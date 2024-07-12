package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.TipoMarca;

public interface ITipoMarcaRepository extends JpaRepository<TipoMarca, Integer>{

	Optional<TipoMarca> findByDescrizione(String colore);

}
