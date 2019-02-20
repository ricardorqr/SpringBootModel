package com.springBootModel.model;

import java.util.LinkedHashMap;
import java.util.Map;


public class CartProduct {

	private PriceType priceType;
	private Product product;
	private Map<CartProduct, Integer> cart = new LinkedHashMap<CartProduct, Integer>();

	public CartProduct(Product product, PriceType priceType) {
		this.product = product;
		this.priceType = priceType;
	}

	public void add(CartProduct product) {
		cart.put(product, getTotal(product) + 1);
	}

	private int getTotal(CartProduct product) {
		if (!cart.containsKey(product)) {
			cart.put(product, 0);
		}
		return cart.get(product);
	}

	public PriceType getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priceType == null) ? 0 : priceType.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProduct other = (CartProduct) obj;
		if (priceType != other.priceType)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
