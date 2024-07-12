package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.TipoAmmortizzatore;

public interface ITipoAmmortizzatoreRepository extends JpaRepository<TipoAmmortizzatore, Integer>{

	Optional<TipoAmmortizzatore> findByDescrizione(String ammo);

}
