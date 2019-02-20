package com.springBootModel.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class Cart {

	private Map<CartProduct, Integer> cart = new LinkedHashMap<CartProduct, Integer>();

	public void add(CartProduct product) {
		cart.put(product, getTotal(product) + 1);
	}

	private int getTotal(CartProduct product) {
		if (!cart.containsKey(product)) {
			cart.put(product, 0);
		}
		return cart.get(product);
	}

	public int getTotal() {
		return cart.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
	}

}
