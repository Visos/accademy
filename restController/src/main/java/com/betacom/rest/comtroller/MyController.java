package com.betacom.rest.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.rest.comtroller.object.Student;


@RestController
@RequestMapping("/rest")
public class MyController {
	
	@RequestMapping("/service1")
	public Student service1() {
		
		Student stud = new Student();
		stud.setCongnome("rossi");
		stud.setNome("valentino");
		return stud;
	}
	
	

}
