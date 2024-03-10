package org.customer.dto;

import org.springframework.stereotype.Component;

@Component
public class DiscountResponse {

	private int discount;

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
