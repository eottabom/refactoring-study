package io.github.eottabom.refactoring._04_long_parameter_list._14_replace_parameter_with_query;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTests {

	@Test
	void discountedPriceWithDiscountLevel2() {
		int quantity = 200;
		double price = 100;
		assertThat(new Order(quantity, price).finalPrice()).isEqualTo(quantity * price * 0.90);
	}

	@Test
	void discountedPriceWithDiscountLevel1() {
		int quantity = 100;
		double price = 100;
		assertThat(new Order(quantity, price).finalPrice()).isEqualTo(quantity * price * 0.95);
	}

}
