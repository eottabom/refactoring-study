package io.github.eottabom.refactoring._05_global_data._17_encapsulate_variable;

public class ExamPolicy {

	// public -> private 으로 변경해주면서 접근을 막아준다.
	private static int passingScore = 60;

	private static boolean onlineExamAllowed = false;

	private static boolean openBookAllowed = false;

	// getter/setter 를 만들어준다.
	public static int getPassingScore() {
		// TODO : validation
		return passingScore;
		// TODO : notify
	}

	public static void setPassingScore(int passingScore) {
		ExamPolicy.passingScore = passingScore;
	}

	public static boolean isOnlineExamAllowed() {
		return onlineExamAllowed;
	}

	public static void setOnlineExamAllowed(boolean onlineExamAllowed) {
		ExamPolicy.onlineExamAllowed = onlineExamAllowed;
	}

	public static boolean isOpenBookAllowed() {
		return openBookAllowed;
	}

	public static void setOpenBookAllowed(boolean openBookAllowed) {
		ExamPolicy.openBookAllowed = openBookAllowed;
	}
}
