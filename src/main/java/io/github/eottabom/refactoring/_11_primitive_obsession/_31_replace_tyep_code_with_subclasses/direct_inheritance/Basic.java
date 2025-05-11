package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.direct_inheritance;

// STEP 1) 우선 서브 클래스로 Basic 을 하나 만든다.
public class Basic extends Member {

	// STEP 4) 그리고 이제 더 이상 grade 는 필요 없어지게 된다.
	public Basic(String name) { //, String grade) {
//		super(name, grade);
		super(name);
	}

	// getGrade 를 오버라이딩 해서 원하는 값을 세팅해준다.
	@Override
	public String getGrade() {
		return "basic";
	}
}
