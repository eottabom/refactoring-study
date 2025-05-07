package io.github.eottabom.refactoring._08_shotgun_surgery._27_move_field._00_before;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

	private String productName;

	private double rate;

	private Delivery delivery;

	public Order(String productName, double rate) {
		this.productName = productName;
		this.rate = rate;
		this.delivery = new Delivery(today());
	}

	public double getRate() {
		return this.rate;
	}

	public void expediteShipping() {
		this.rate += 0.05;
	}

	public double calculateTotalCost(double basePrice) {
		BigDecimal price = BigDecimal.valueOf(basePrice);
		return price.add(price.multiply(BigDecimal.valueOf(this.rate))).doubleValue();
	}

	private LocalDateTime today() {
		return LocalDateTime.now();
	}

}
