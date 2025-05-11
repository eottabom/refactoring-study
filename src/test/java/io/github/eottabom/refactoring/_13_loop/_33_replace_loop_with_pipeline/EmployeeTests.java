package io.github.eottabom.refactoring._13_loop._33_replace_loop_with_pipeline;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTests {

	@Test
	void slackIdsByTeam() {
		Employee yukeun = new Employee("platform", null);
		Employee eottabom = new Employee("design", "eottabom");

		List<String> result = Employee.slackIdsByTeam(List.of(yukeun, eottabom), "design");

		assertThat(result).containsExactly("eottabom");
	}

}
