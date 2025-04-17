package io.github.eottabom.refactoring._04_long_parameter_list._00_before;

public class Order {

	private final int quantity;

	private final double itemPrice;

	public Order(int quantity, double itemPrice) {
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}

	public double finalPrice() {
		double basePrice = this.itemPrice * this.quantity;
		int discountLevel = (this.quantity > 100) ? 2 : 1;
		return this.discountPrice(basePrice, discountLevel);
	}

	private double discountPrice(double basePrice, int discountLevel) {
		return (discountLevel == 2) ? basePrice * 0.9 : basePrice * 0.95;
	}

}
