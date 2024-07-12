package com.betacom.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestControllerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args ->{
			System.out.println("Run command line...");
		};
	}

}
