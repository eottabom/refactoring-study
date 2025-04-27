package io.github.eottabom.refactoring._06_mutable_data._20.remove_setting_method;

public class Person {

	private String name;

	private int id;

	// 추가로 생성한다.
	public Person(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	// 제거한다.
//	public void setId(int id) {
//		this.id = id;
//	}
}
