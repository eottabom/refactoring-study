package io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value;

// @formatter:off
public class School {

	private Student student;


	/*
		값들을 reference object 로 참조하고 있다.
	 */
	public String studentName() {
		return this.student.name();
	}

	// STEP 5) reference object 대신 새로운 객체로 변경해준다.
	public void studentName(String studentName) {
//		this.student.name(studentName);
		this.student = new Student(studentName, this.studentGrade());
	}

	public String studentGrade() {
		return this.student.grade();
	}

	public void studentGrade(String studentGrade) {
//		this.student.grade(studentGrade);
		this.student = new Student(this.studentName(), studentGrade);
	}

}
// @formatter:on