package io.github.eottabom.refactoring._08_shotgun_surgery._28_inline_function;

public class Grade {

	// @formatter:off
	public String getGrade(Student student) {
		return (student.getSkippedHomework() > 3) ? "C" : "A";
//		return skippedHomeworkExceeded(student) ? "C" : "A";
	}

	/*
		사실 이 메서드는 아래 코드를 읽는거랑 크게 다름이 없어서,
		이런 경우 Inline Function 을 하면 된다.
	 */
	// @formatter:on
	private boolean skippedHomeworkExceeded(Student student) {
		return student.getSkippedHomework() > 3;
	}

}
