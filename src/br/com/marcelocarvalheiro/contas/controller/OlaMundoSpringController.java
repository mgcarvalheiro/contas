package br.com.marcelocarvalheiro.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoSpringController {
	
	  @RequestMapping("/olaMundoSpring")
	  public String execute() {
	    System.out.println("Executando a lógica com Spring MVC");
	    return "ok";
	  }

}