package io.github.eottabom.refactoring._05_global_data._00_before;

public class ExamRoom {

	public static void main(String[] args) {
		System.out.println(ExamPolicy.passingScore);
		ExamPolicy.passingScore = 100;
		ExamPolicy.openBookAllowed = false;
	}

}
