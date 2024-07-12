package com.betacom.sbjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.betacom.sbjdbc.dao.BusinessComponent;

@SpringBootApplication
public class ProjectSBjdbcApplication {
	
	@Autowired
	public BusinessComponent bu;

	public static void main(String[] args) {
		SpringApplication.run(ProjectSBjdbcApplication.class, args);
	}
	
	
	//componenete di spring che consente di utilizzare un prcesso prima dell'esecuzione tottale dell'applicazione
	@Bean
	CommandLineRunner commandLineRunner() {
		return args-> {
			bu.listUffici();
			
		};
	}

}
