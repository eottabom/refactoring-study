package io.github.eottabom.refactoring._06_mutable_date._18_split_variable;

import io.github.eottabom.refactoring._06_mutable_data._18_split_variable.GameCharacter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameCharacterTests {

	@Test
	void moveDistance() {
		GameCharacter gameCharacter = new GameCharacter(10d, 20d, 10, 5);
		assertThat(75d).isEqualTo(gameCharacter.moveDistance(10));
		assertThat(425d).isEqualTo(gameCharacter.moveDistance(20));
	}

}
