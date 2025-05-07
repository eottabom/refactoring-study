package io.github.eottabom.refactoring._06_mutable_date._18_split_variable;

import io.github.eottabom.refactoring._06_mutable_data._18_split_variable.GameCharacter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameCharacterTests {

	@Test
	void moveDistance() {
		GameCharacter gameCharacter = new GameCharacter(10d, 20d, 10, 5);
		assertThat(gameCharacter.moveDistance(10)).isEqualTo(75d);
		assertThat(gameCharacter.moveDistance(20)).isEqualTo(425d);
	}

}
