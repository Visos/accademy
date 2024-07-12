package com.betacom.rest.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")	//prefisso url per chiamare la funzione
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello (Model model) {
		
		return "Hello";
		}
	
	


}
