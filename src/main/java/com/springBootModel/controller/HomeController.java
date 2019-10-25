package com.springBootModel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springBootModel.model.Product;
import com.springBootModel.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	@Cacheable(value = "products")
	public ModelAndView index() {
		List<Product> products = productService.getAllProducts();
		ModelAndView modelAndView = new ModelAndView("baseModel");
		modelAndView.addObject("products", products);
		return modelAndView;
	}
	
}
