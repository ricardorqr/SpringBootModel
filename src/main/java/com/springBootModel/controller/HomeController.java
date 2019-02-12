package com.springBootModel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "home";
	}

}
