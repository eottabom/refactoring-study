package io.github.eottabom.refactoring._04_long_parameter_list._14_replace_parameter_with_query;

public class Order {

	private final int quantity;

	private final double itemPrice;

	public Order(int quantity, double itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public double finalPrice() {
		double basePrice = this.itemPrice * this.quantity;
		// STEP1) 함수를 추출하고, inline 리팩토링을 한다.
		int discountLevel = discountLevel();
		// STEP2) discountLevel 매개변수를 전달하지 않아도 된다.
//		return this.discountPrice(basePrice, discountLevel);
		return this.discountPrice(basePrice);
	}

	private int discountLevel() {
		return (this.quantity > 100) ? 2 : 1;
	}

	// remove discountLevel parameter
	private double discountPrice(double basePrice) {
		return (discountLevel() == 2) ? basePrice * 0.9 : basePrice * 0.95;
	}

}
