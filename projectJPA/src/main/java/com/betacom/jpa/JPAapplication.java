package com.betacom.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.betacom.jpa.process.ProcessTest;

@SpringBootApplication
public class JPAapplication {

	@Autowired
	ProcessTest proS;
	
	public static void main(String[] args) {
		SpringApplication.run(JPAapplication.class, args);
	}
	
	
	
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			//System.out.println("Init app");
			proS.createNewSocio();
		};
	}

}
