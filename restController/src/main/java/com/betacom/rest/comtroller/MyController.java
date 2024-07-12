package com.betacom.rest.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.rest.comtroller.object.RequestObject;
import com.betacom.rest.comtroller.object.ResponseObject;
import com.betacom.rest.comtroller.object.Student;


@RestController
@RequestMapping("/rest")
public class MyController {
	
	@RequestMapping(value = "/service1" , method = RequestMethod.GET)
	public Student service1() {
		
		Student stud = new Student();
		stud.setCongnome("rossi");
		stud.setNome("valentino");
		return stud;
	}
	
	@GetMapping("/service2")
	public Student service2(String nome, @RequestParam(value = "cognome", required = false) String cognome) {
		Student stud = new Student();
		if (nome == null)
			stud.setNome("...");
		else
			stud.setNome(nome);
		if (cognome == null)
			stud.setCongnome("...");
		else
			stud.setNome(cognome);
		
		return stud;
	}
	
	@GetMapping("/service3/{cognome}")
	public Student service3(String nome, @PathVariable("cognome") String cognome) {
		Student stud = new Student();
		if (nome == null)
			stud.setNome("...");
		else
			stud.setNome(nome);
		if (cognome == null)
			stud.setCongnome("...");
		else
			stud.setNome(cognome);
		
		return stud;
	}
	
	@PostMapping("/service4")
	public ResponseObject<Student> create(@RequestBody(required = true)RequestObject req) {
		Student s =new Student();
		ResponseObject<Student> resp = new ResponseObject<Student>();
		resp.setRc(true);
		if(req.getAzione() == null) {
			resp.setRc(false);
			resp.setMessage("azione non validata");
		}
		if("add".equalsIgnoreCase(req.getAzione())) {
			if(req.getMode() == null) {
				s.setCongnome(req.getCongnome());
				s.setNome(req.getNome());
			}else if(req.getMode().equalsIgnoreCase("upper")) {
				s.setCongnome(req.getCongnome().toUpperCase());
				s.setNome(req.getNome().toUpperCase());
			}else {
				s.setCongnome(req.getCongnome().toLowerCase());
				s.setNome(req.getNome().toLowerCase());
			}
			resp.setDati(s);
		}else {
			resp.setRc(false);
			resp.setMessage("azione non validata");
		}
		return resp;
	}
	
	

}
