package com.springBootModel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
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

	public Collection<CartItem> getItems() {
		return items.keySet();
	}

}
