package com.springBootModel.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Price {

	private BigDecimal value;
	private PriceType priceType;

	public PriceType getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Price [value=" + value + ", priceType=" + priceType + "]";
	}

}
