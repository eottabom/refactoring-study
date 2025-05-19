package io.github.eottabom.refactoring._18_middle_man._38_remove_middle_man;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTests {

	@Test
	void getLeader() {
		Character archer = new Character("archer", null);
		Character mage = new Character("mage", new Guild(archer));

		// @formatter:off
		/*
			getLeader 를 호출하는 것이 아니라, Character 를 호출하고
			leader 를 호출하는것이 좋은 거 같다고 생각들면(지나치게 캡슐화 한 것 같다..,
			그 때는 리팩토링을 할 수 있다.
			mage.getGuild().getLeader()
		 */
//		assertThat(mage.getLeader()).isEqualTo(archer);
		// @formatter:on
		assertThat(mage.getGuild().getLeader()).isEqualTo(archer);
	}

}
