package com.springBootModel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class OlaMundoController {

	@RequestMapping("/")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "ok";
	}

}
