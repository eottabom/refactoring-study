package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.indirect_inheritance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTests {

	@Test
	void memberGrade() {
		assertThat(new PremiumMember("eottabom", "vip").capitalizedGrade()).isEqualTo("Vip");
		assertThat(new BasicMember("eottabom", "basic").capitalizedGrade()).isEqualTo("Basic");
		assertThatThrownBy(() -> new Member("eottabom", "wrong")).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("wrong");
	}

}
