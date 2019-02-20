package com.springBootModel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.springBootModel.model.Cart;
import com.springBootModel.model.CartProduct;
import com.springBootModel.model.PriceType;
import com.springBootModel.model.Product;
import com.springBootModel.service.ProductService;
import com.springBootModel.validation.ProductValidation;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CartController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Cart cart;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidation());
	}

	@RequestMapping("/cart/add")
	public ModelAndView add(Long productId, PriceType priceType, HttpSession session) {
		CartProduct cartProduct = createCartProduct(productId, priceType);
		cart.add(cartProduct);
		session.setAttribute("cart", cart);
		ModelAndView modelAndView = new ModelAndView("redirect:/product/list");
		return modelAndView;
	}

	private CartProduct createCartProduct(Long produtoId, PriceType priceType) {
		Product product = productService.getProduct(produtoId);
		return new CartProduct(product, priceType);
	}

}
