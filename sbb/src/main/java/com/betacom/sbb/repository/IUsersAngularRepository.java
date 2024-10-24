package com.betacom.sbb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.sbb.pojo.UsersAngular;

public interface IUsersAngularRepository extends JpaRepository<UsersAngular, Integer>{

    Optional<UsersAngular> findByUserNameAndPwd(String userName, String pwd);
    Optional<UsersAngular> findByUserName(String userName);
}
