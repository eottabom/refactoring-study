package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.direct_inheritance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MemberTests {

	@Test
	void memberGrade() {
		// STEP 7) 팩토리 메서드로 변경한다.
//		assertThat(new Member("eottabom", "basic").getGrade()).isEqualTo("basic");
//		assertThat(new Member("eottabom", "vip").getGrade()).isEqualTo("vip");
		assertThat(Member.create("eottabom", "basic").getGrade()).isEqualTo("basic");
		assertThat(Member.create("eottabom", "vip").getGrade()).isEqualTo("vip");
		assertThatThrownBy(() -> Member.create("eottabom", "invalid")).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("invalid");
	}

}
