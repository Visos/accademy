package com.betacom.rest.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")	//prefisso url per chiamare la funzione
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello () { return "Hello";}
	
	


}
