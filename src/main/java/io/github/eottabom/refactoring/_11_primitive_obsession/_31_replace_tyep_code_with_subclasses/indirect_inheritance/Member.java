package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.indirect_inheritance;

import java.util.List;

// @formatter:off
/*
	이 경우는 이미 상속 구조가 있어서,
	이 상속 구조에대가 넣기에는 애매하고 간접적인 상속을 활용하는 경우.
 */
// @formatter:on
public class Member {

	private final String name;

//	private final String gradeValue;

	private MemberGrade grade;

	public Member(String name, String gradeValue) {
//		validate(gradeValue);
		this.name = name;
//		this.gradeValue = this.gradeValue;
		this.grade = this.grade(gradeValue);
	}

	public MemberGrade grade(String gradeValue) {
		return switch (gradeValue) {
			case "basic" -> new Basic();
			case "premium" -> new Premium();
			case "vip" -> new Vip();
			default -> throw new IllegalArgumentException(gradeValue);
		};
	}

//	private void validate(String grade) {
//		List<String> validGrades = List.of("basic", "premium", "vip");
//		if (!validGrades.contains(grade)) {
//			throw new IllegalArgumentException(grade);
//		}
//	}

	public String capitalizedGrade() {
		return this.grade.capitalizedGrade();
//		return this.grade.substring(0, 1).toUpperCase() + this.grade.substring(1).toLowerCase();
	}

	// @formatter:off
	@Override
	public String toString() {
		return "Member{" +
				"name='" + this.name + '\'' +
				", grade='" + this.grade.toString() + '\'' +
				'}';
	}
	// @formatter:on

}
