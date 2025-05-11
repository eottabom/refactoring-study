package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.direct_inheritance;

// STEP 2) 두번째 등급을 나타내는 서브 클래스를 만들어준다.
public class Premium extends Member {

	// STEP 4) 그리고 이제 더 이상 grade 는 필요 없어지게 된다.
	public Premium(String name) { //, String grade) {
//		super(name, grade);
		super(name);
	}

	@Override
	public String getGrade() {
		return "premium";
	}

}
