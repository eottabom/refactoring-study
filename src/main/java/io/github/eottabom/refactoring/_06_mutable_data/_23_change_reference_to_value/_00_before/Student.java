package io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value._00_before;

public class Student {

	private String name;

	private String grade;

	public String name() {
		return this.name;
	}

	public void name(String name) {
		this.name = name;
	}

	public String grade() {
		return this.grade;
	}

	public void grade(String grade) {
		this.grade = grade;
	}

}
