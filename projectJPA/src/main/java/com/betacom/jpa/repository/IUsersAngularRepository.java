package com.betacom.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.pojo.UsersAngular;

public interface IUsersAngularRepository extends JpaRepository<UsersAngular, Integer>{
	Optional<UsersAngular> findByUserName(String user);
	Optional<UsersAngular> findByUserNameAndPwd(String user, String pwd);

}
