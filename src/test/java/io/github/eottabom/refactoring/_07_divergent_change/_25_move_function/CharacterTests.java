package io.github.eottabom.refactoring._07_divergent_change._25_move_function;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTests {

	@Test
	void restPenalty() {
		Character character = new Character(2, new ClassType(true));
		assertThat(7.0).isEqualTo(character.getRestPenalty());
		// basePenalty(2.0) + baseFatigue(5.0)

		character = new Character(5, new ClassType(true));
		assertThat(9.4).isEqualTo(character.getRestPenalty());
		// basePenalty(2.0) + [5.0 + (5 - 3) * 1.2 = 2.4] = 9.4

		character = new Character(5, new ClassType(false));
		assertThat(12.0).isEqualTo(character.getRestPenalty());
		// basePenalty(2.0) + (5 * 2.0) = 12.0
	}

}
