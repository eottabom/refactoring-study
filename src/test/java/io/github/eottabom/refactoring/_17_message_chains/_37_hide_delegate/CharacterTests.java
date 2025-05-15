package io.github.eottabom.refactoring._17_message_chains._37_hide_delegate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTests {

	@Test
	void leader() {
		Character archer = new Character("archer");
		Character mage = new Character("mage");
		archer.setGuild(new Guild("g12345", mage));

		// 지금은 이렇게 getGuild 에서 leader 를 가져오는데, 캐릭터인 archer 에서 정보를 가져오게 하는것이다.
//		Character leader = archer.getGuild().getLeader();
		Character leader = archer.getLeader();
		assertThat(leader).isEqualTo(mage);
	}

}
