package io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value._01_not_equals;

import java.util.Objects;

public class Student {

	// STEP 2) final
	private final String name;

	private final String grade;

	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	public String name() {
		return this.name;
	}

	public String grade() {
		return this.grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, grade);
	}

}