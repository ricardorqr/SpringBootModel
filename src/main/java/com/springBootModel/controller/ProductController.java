package com.springBootModel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springBootModel.model.PriceType;
import com.springBootModel.model.Product;
import com.springBootModel.service.ProductService;
import com.springBootModel.validation.ProductValidation;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidation());
	}

	@RequestMapping("/product/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("/product/form");
		modelAndView.addObject("types", PriceType.values());
		return modelAndView;
	}

	@RequestMapping("/product/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", productService.getAllProducts());
		return modelAndView;
	}

	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return form(product);
		}

		productService.save(product);
		redirectAttributes.addFlashAttribute("success", "New product inserted");
		ModelAndView modelAndView = new ModelAndView("redirect:list");
		return modelAndView;
	}

}
