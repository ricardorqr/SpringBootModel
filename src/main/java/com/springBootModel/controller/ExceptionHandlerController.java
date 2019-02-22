package com.springBootModel.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView trataExceptionGenerica(Exception exception) {
		exception.printStackTrace();
		ModelAndView modelAndView = new ModelAndView("error/error");
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
}