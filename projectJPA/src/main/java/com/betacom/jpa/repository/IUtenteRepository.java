package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.Utente;

public interface IUtenteRepository extends JpaRepository<Utente, Integer>{
	Optional<Utente> findByUserName(String userName);
	Optional<Utente> findByUserNameAndPwd(String userName, String pwd);
}
