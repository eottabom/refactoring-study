package io.github.eottabom.refactoring._06_mutable_date._18_split_variable;

import io.github.eottabom.refactoring._06_mutable_data._18_split_variable.GameStore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameStoreTests {

	@Test
	void applyPromotion() {
		GameStore gameStore = new GameStore();

		assertThat(gameStore.applyPromotion(50d, 100)).isEqualTo(50d);
		assertThat(gameStore.applyPromotion(51d, 100)).isEqualTo(51d - 2);
		assertThat(gameStore.applyPromotion(50d, 101)).isEqualTo(50d - 1);
		assertThat(gameStore.applyPromotion(51d, 101)).isEqualTo(51d - 2 - 1);
	}

}
