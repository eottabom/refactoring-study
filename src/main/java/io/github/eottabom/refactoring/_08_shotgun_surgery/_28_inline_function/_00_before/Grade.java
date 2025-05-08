package io.github.eottabom.refactoring._08_shotgun_surgery._28_inline_function._00_before;

public class Grade {

	public String getGrade(Student student) {
		return skippedHomeworkExceeded(student) ? "C" : "A";
	}

	private boolean skippedHomeworkExceeded(Student student) {
		return student.getSkippedHomework() > 3;
	}

}
