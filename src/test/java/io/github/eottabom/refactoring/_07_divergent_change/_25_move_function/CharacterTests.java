package io.github.eottabom.refactoring._07_divergent_change._25_move_function;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTests {

	@Test
	void restPenalty() {
		Character character = new Character(2, new ClassType(true));
		assertThat(character.getRestPenalty()).isEqualTo(7.0);
		// basePenalty(2.0) + baseFatigue(5.0)

		character = new Character(5, new ClassType(true));
		assertThat(9.4).isEqualTo(character.getRestPenalty());
		assertThat(character.getRestPenalty()).isEqualTo(9.4);
		// basePenalty(2.0) + [5.0 + (5 - 3) * 1.2 = 2.4] = 9.4

		character = new Character(5, new ClassType(false));
		assertThat(character.getRestPenalty()).isEqualTo(12.0);
		// basePenalty(2.0) + (5 * 2.0) = 12.0
	}

}
