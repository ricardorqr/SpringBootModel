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

import com.springBootModel.model.CartItem;
import com.springBootModel.model.PriceType;
import com.springBootModel.model.Product;
import com.springBootModel.service.Cart;
import com.springBootModel.service.ProductService;
import com.springBootModel.validation.ProductValidation;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
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
		CartItem cartProduct = createItem(productId, priceType);
		cart.add(cartProduct);
		session.setAttribute("cart", cart);
		return new ModelAndView("redirect:/cart");
	}

	private CartItem createItem(Long produtoId, PriceType priceType) {
		Product product = productService.getProduct(produtoId);
		return new CartItem(product, priceType);
	}

	@RequestMapping("/cart")
	public ModelAndView itens(HttpSession session) {
		return new ModelAndView("cart/items");
	}

	@RequestMapping("/cart/remove")
	public ModelAndView remover(Long productId, PriceType priceType) {
		cart.remover(productId, priceType);
		return new ModelAndView("redirect:/cart");
	}

}
