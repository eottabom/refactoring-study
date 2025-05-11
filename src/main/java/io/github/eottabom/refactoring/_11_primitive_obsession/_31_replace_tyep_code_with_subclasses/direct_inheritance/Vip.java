package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.direct_inheritance;

public class Vip extends Member {

	// STEP 4) 그리고 이제 더 이상 grade 는 필요 없어지게 된다.
	public Vip(String name) { //, String grade) {
//		super(name, grade);
		super(name);
	}

	@Override
	public String getGrade() {
		return "vip";
	}

}
