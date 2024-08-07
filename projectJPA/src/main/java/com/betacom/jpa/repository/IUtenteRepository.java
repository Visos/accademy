package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.pojo.Utente;

@Repository
public interface IUtenteRepository extends JpaRepository<Utente, Integer>  {

    Optional<Utente> findByUsername(String username);
}
