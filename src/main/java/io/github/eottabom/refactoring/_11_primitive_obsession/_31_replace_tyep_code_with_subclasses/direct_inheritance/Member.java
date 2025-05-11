package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.direct_inheritance;

// @formatter:off
/*
	이 경우는 직접 현재 클래스에서 상속하는 서브 클래스를 만들 수 있는 경우.
 */
// @formatter:on
public abstract class Member {

	private final String name;

	// NOTE: grade 등급에 따라, 하는 일이 앞으로 달라진다고 가정을 한다.
	// STEP 4) 그리고 이제 더 이상 grade 는 필요 없어지게 된다.
//	private final String grade;

	// @formatter:off
	// STEP 3) 생성자는 protected 으로 변경해준다. 하위 클래스에서만 사용될 것이라ㅣㅅ.
//	public Member(String name, String grade) {
	protected Member(String name) { //, String grade) {
//		validate(grade);
		this.name = name;
//		this.grade = grade;
	}
	// @formatter:on

	// STEP 2) 팩토리성 역할을 하는 메서드를 하나 만들어준다.
	public static Member create(String name, String grade) {
		// STEP 4) 그리고 이제 더 이상 grade 는 필요 없어지게 된다.
		return switch (grade) {
			case "basic" -> new Basic(name);
			case "premium" -> new Premium(name);
			case "vip" -> new Vip(name);
			default -> throw new IllegalArgumentException(grade);
		};
	}

	// @formatter:off
	// STEP 5) validate 로직은 switch 에서 처리되기 때문에 더 이상 유효하지 않다.
//	private void validate(String grade) {
//		List<String> validGrades = List.of("basic", "premium", "vip");
//		if (!validGrades.contains(grade)) {
//			throw new IllegalArgumentException(grade);
//		}
//	}

	// STEP 6) abstract 로 변경한다. -> 자연스럽게 Member 클래스는 abstract 로 변경된다.
	protected abstract String getGrade();
//	{
//		return this.grade;
//	}

	// @formatter:off
	@Override
	public String toString() {
		return "Member{" +
				"name='" + this.name + '\'' +
				", grade='" + this.getGrade() + '\'' +
				'}';
	}
	// @formatter:on

}
