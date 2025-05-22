package io.github.eottabom.refactoring._19_insider_trading;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTests {

	@Test
	void isDiscountTarget() {
		Discount service = new Discount();

		assertThat(new Member(LocalDate.of(2021, 12, 31), true).isDiscountTarget()).isTrue();
		assertThat(new Member(LocalDate.of(2021, 12, 31), false).isDiscountTarget()).isFalse();
		assertThat(new Member(LocalDate.of(2022, 1, 2), true).isDiscountTarget()).isFalse();
	}

}
