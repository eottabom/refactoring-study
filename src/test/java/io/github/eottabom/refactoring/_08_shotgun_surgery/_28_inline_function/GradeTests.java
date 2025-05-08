package io.github.eottabom.refactoring._08_shotgun_surgery._28_inline_function;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GradeTests {

	@Test
	void grade() {
		Grade grade = new Grade();

		assertThat(grade.getGrade(new Student(5))).isEqualTo("C");
		assertThat(grade.getGrade(new Student(2))).isEqualTo("A");
	}

}
