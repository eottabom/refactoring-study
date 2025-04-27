package io.github.eottabom.refactoring._06_mutable_date._18_split_variable;

import io.github.eottabom.refactoring._06_mutable_data._18_split_variable.GameStore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameStoreTests {

	@Test
	void applyPromotion() {
		GameStore gameStore = new GameStore();
		assertThat(50d).isEqualTo(gameStore.applyPromotion(50d, 100));
		assertThat(51d - 2).isEqualTo(gameStore.applyPromotion(51d, 100));
		assertThat(50d - 1).isEqualTo(gameStore.applyPromotion(50d, 101));
		assertThat(51d - 2 - 1).isEqualTo(gameStore.applyPromotion(51d, 101));
	}

}
