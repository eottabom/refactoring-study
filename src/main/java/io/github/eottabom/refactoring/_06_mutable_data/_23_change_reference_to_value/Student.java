package io.github.eottabom.refactoring._06_mutable_data._23_change_reference_to_value;

import java.util.Objects;

// @formatter:off
/*
	Student 를 Value Object 로 바꾸고 싶다면, 가장 해줘야 하는 것은, 생성자로 설정한다.

	아래의 경우는 이뮤터블한 객체를 생성한거고, 사실은 Java 14 이후는 Record 로 구현가능하다.

	public record Student(String name, String grade) {} // record 안에는 equals, hashcode 는 있고, setter 는 따로 없음.
 */
public class Student {

	// STEP 2) final
	private final String name;
	// private String name;

	private final String grade;
	// private String grade;

	// STEP 1) 생성자 추가
	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	public String name() {
		return this.name;
	}

	// STEP 3) setter 삭제
//	public void name(String name) {
//		this.name = name;
//	}

	public String grade() {
		return this.grade;
	}

	// setter 삭제
//	public void grade(String grade) {
//		this.grade = grade;
//	}

	// STEP 4) 반드시 중요한 것중에 하나가 있는데, 그것이 바로 Equals 와 hashCode 를 만들어야 한다.
	// 값을 값을 가지고 있는 객체라면 같은 Value 라는 것을 검증할 수 있어야 한다.
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
	}

	// 해시 코드 같은 경우는 Equals 와 반드시 같이 구현해야하는 함수 중 하나이다.
	// 이유는 인스턴스가 어떤 콜렉션 안에 들어갈 때 해시 값을 검사하는 경우, (ex. HashSet)
	// 값이 같으면 해시코드가 같아하고, 값이 같지 않으면 해시코드도 달라야한다.
	@Override
	public int hashCode() {
		return Objects.hash(name, grade);
	}
}
// @formatter:on