package io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value._00_before;

public class School {

	private Student student;

	public String studentName() {
		return this.student.name();
	}

	public void studentName(String studentName) {
		this.student.name(studentName);
	}

	public String studentGrade() {
		return this.student.grade();
	}

	public void studentGrade(String studentGrade) {
		this.student.grade(studentGrade);
	}

}
