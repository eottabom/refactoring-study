package io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier._02;

public class Monster {

	private final String name;

	public Monster(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
