package io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

public class Player {

	private final String name;

	private final List<Item> inventory;

	public Player(String name, List<Item> inventory) {
		this.name = name;
		this.inventory = inventory;
	}

	public List<Item> getInventory() {
		return this.inventory;
	}

	public String getName() {
		return this.name;
	}

}
