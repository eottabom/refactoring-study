package io.github.eottabom.refactoring._05_global_data._17_encapsulate_variable;

public class ExamRoom {

	public static void main(String[] args) {
		System.out.println(ExamPolicy.getPassingScore());
		// 값을 말도 안되는 값을 설정할 수 있다. 이런 값들이 가능해지기 때문에..
		// 메서드로 감싸서 벨리데이션하는게 낫다.

		// getter/setter 를 만들어주고 감싸주고, 변수를 private 으로 변경해준다.
		ExamPolicy.setPassingScore(100);
		ExamPolicy.setOpenBookAllowed(false);
	}

}
