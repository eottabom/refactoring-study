package io.github.eottabom.refactoring._06_mutable_date._18_split_variable;

import io.github.eottabom.refactoring._06_mutable_data._18_split_variable.Shield;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShieldTests {

	@Test
	void updateShield() {
		Shield shield = new Shield();
		shield.updateShield(10, 5);

		assertThat(50d).isEqualTo(shield.getCoverage());
		assertThat(30d).isEqualTo(shield.getDurability());

		shield.updateShield(5, 5);

		assertThat(25d).isEqualTo(shield.getCoverage());
		assertThat(20d).isEqualTo(shield.getDurability());
	}

}
