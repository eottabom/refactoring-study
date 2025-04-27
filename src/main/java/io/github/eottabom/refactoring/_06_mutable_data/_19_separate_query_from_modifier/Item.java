package io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier;

public class Item {

	private final double value;

	public Item(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

}
