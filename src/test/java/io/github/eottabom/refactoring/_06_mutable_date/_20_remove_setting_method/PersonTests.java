package io.github.eottabom.refactoring._06_mutable_date._20_remove_setting_method;

import io.github.eottabom.refactoring._06_mutable_data._20.remove_setting_method.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTests {

	@Test
	void person() {
//		Person person = new Person();
//		person.setId(10); // 이것 변경되지 않기를 바라는 값이다.

		// TO-BE
		Person person = new Person(10);

		person.setName("yukeun");
		assertThat(person.getId()).isEqualTo(10);
		assertThat(person.getName()).isEqualTo("yukeun");
		person.setName("eottabom");
		assertThat(person.getName()).isEqualTo("eottabom");
	}

}
