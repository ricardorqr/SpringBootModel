package com.springBootModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springBootModel.service.Cart;

@Controller
public class PaymentController {

	@Autowired
	private Cart cart;

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public ModelAndView finalizar(RedirectAttributes redirectAttributes) {
		System.out.println(cart.getTotal());
		redirectAttributes.addFlashAttribute("success", "Payment successful");
		return new ModelAndView("redirect:/product/list");
	}

}
