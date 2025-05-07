package io.github.eottabom.refactoring._08_shotgun_surgery._27_move_field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTests {

	@Test
	void calculateTotalCost() {
		Order order = new Order("monitor", 0.5);
		assertThat(order.calculateTotalCost(100)).isEqualTo(150.0);

		order.expediteShipping();
		assertThat(order.calculateTotalCost(100)).isEqualTo(155.0);
	}

}
