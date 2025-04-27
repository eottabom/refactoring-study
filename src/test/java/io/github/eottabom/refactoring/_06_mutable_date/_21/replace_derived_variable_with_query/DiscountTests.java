package io.github.eottabom.refactoring._06_mutable_date._21.replace_derived_variable_with_query;

import io.github.eottabom.refactoring._06_mutable_data._21.replace_derived_variable_with_query.Discount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTests {

	@Test
	void discount() {
		Discount discount = new Discount(100);
		// assertThat(discount.getDisCountedTotal()).isEqualTo(100); // 코드를 수정하기 전에는 사실 버그 였다.

		discount.setDiscount(10);
		assertThat(discount.getDisCountedTotal()).isEqualTo(90);
	}

}
