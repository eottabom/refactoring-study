package io.github.eottabom.refactoring._04_long_parameter_list._00_before;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// @formater:off
/*
	리팩토링을 할 때는 이렇게 테스트 코드가 있어야만 한다.
	그래야, 우리가 리팩토링 제대로 했는지 알 수 가 있다.
 */
// @formater:on
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
