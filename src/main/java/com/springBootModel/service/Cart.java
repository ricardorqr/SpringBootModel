package com.springBootModel.service;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.springBootModel.model.CartItem;
import com.springBootModel.model.PriceType;
import com.springBootModel.model.Product;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = TARGET_CLASS)
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<CartItem, Integer> items = new LinkedHashMap<CartItem, Integer>();

	public void add(CartItem item) {
		items.put(item, getQuantity(item) + 1);
	}

	public Integer getQuantity(CartItem item) {
		if (!items.containsKey(item)) {
			items.put(item, 0);
		}
		return items.get(item);
	}

	public int getQuantity() {
		return items.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
	}

	public BigDecimal getTotal(CartItem item) {
		return item.getTotal(getQuantity(item));
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (CartItem item : items.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}

	public Collection<CartItem> getItems() {
		return items.keySet();
	}

	public void remover(Long productId, PriceType priceType) {
		Product product = new Product();
		product.setId(productId);
		items.remove(new CartItem(product, priceType));
	}

}
