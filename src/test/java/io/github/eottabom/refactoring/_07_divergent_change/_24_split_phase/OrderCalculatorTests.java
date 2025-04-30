package io.github.eottabom.refactoring._07_divergent_change._24_split_phase;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderCalculatorTests {

	@Test
	void discountAndFreeDelivery() {
		OrderCalculator orderCalculator = new OrderCalculator();

		double result = orderCalculator.calculateOrderPrice(new MenuItem(10000, 3, 0.2), 4,
				new DeliveryOption(3000, 35000));

		// basePrice = 10000 * 4 = 40000
		// discount = 40000 * 0.2 = 8000
		// deliveryFree = 0
		// result = 40000 - 8000 + 0 = 32000
		assertThat(result).isEqualTo(32000);
	}

	@Test
	void withoutDiscountAndFreeDelivery() {
		OrderCalculator calculator = new OrderCalculator();

		double result = calculator.calculateOrderPrice(new MenuItem(10000, 3, 0.2), 2, new DeliveryOption(3000, 35000));

		// basePrice = 10000 * 2 = 20000
		// discount = 0
		// deliveryFee = 3000 * 2 = 6000
		// result = 20000 - 0 + 6000 = 26000
		assertThat(result).isEqualTo(26000);
	}

}
