package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses.indirect_inheritance;

// @formatter:off
/*
	grade 를 표현 해줄 수 있는 새로운 클래스를 만들어주고,
	이 클래스를 상속하는 클래스를 만들어준다. basic, premium, vip
 */
// @formatter:on
public class MemberGrade {

	public String capitalizedGrade() {
		return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
	}

}
