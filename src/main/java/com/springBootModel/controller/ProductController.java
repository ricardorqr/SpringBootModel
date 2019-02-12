package com.springBootModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springBootModel.model.PriceType;
import com.springBootModel.model.Product;
import com.springBootModel.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("product/form");
		modelAndView.addObject("types", PriceType.values());
		return modelAndView;
	}

	@RequestMapping("/addProduct")
	public String addProduct(Product product) {
		System.out.println(product.getTitle());
	    System.out.println(product.getDescription());
	    System.out.println(product.getPages());
	    
	    Product savedProduct = productService.save(product);
	    System.out.println(savedProduct);
	    
		return "product/ok";
	}
	
	@RequestMapping("/listaConta")
	public String lista(Model model) {
		model.addAttribute("listaConta", null);
		return "formulario";
	}
	
}
