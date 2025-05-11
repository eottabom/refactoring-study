package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.indirect_inheritance._00_before;

import java.util.List;

public class Member {

	private final String name;

	private final String grade;

	public Member(String name, String grade) {
		validate(grade);
		this.name = name;
		this.grade = grade;
	}

	private void validate(String grade) {
		List<String> validGrades = List.of("basic", "premium", "vip");
		if (!validGrades.contains(grade)) {
			throw new IllegalArgumentException(grade);
		}
	}

	public String capitalizedGrade() {
		return this.grade.substring(0, 1).toUpperCase() + this.grade.substring(1).toLowerCase();
	}

	// @formatter:off
	@Override
	public String toString() {
		return "Member{" +
				"name='" + this.name + '\'' +
				", grade='" + this.grade + '\'' +
				'}';
	}
	// @formatter:on

}
