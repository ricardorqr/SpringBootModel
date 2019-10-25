package com.springBootModel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentController {

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public ModelAndView finalizar(HttpSession session, RedirectAttributes redirectAttributes) {
		session.removeAttribute("cart");
		redirectAttributes.addFlashAttribute("success", "Payment successful");
		return new ModelAndView("redirect:/");
	}

}
