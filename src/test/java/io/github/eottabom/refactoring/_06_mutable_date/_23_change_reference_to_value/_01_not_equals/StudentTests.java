package io.github.eottabom.refactoring._06_mutable_date._23_change_reference_to_value._01_not_equals;

import io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value._01_not_equals.Student;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTests {

	@Test
	void equals() {
		// equals 가 없다면, 이 값은 다른 값이다.
		// 기존적으로 자바의 Equals 구현체가 레퍼런스의 동일성을 확인하는 코드이기 때문에 반드시 구현해야 한다.
		Student student1 = new Student("1234", "1234");
		Student student2 = new Student("1234", "1234");
		assertThat(student1).isEqualTo(student2);
	}

}
