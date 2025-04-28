package io.github.eottabom.refactoring._06_mutable_date._23_change_reference_to_value;

import io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value.Student;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTests {

	@Test
	void equals() {
		// 같은 값을 가지고 있다면 student1 과 student2 는 같은 값이어야한다.
		Student student1 = new Student("1234", "1234");
		Student student2 = new Student("1234", "1234");
		assertThat(student1).isEqualTo(student2);
	}

}
