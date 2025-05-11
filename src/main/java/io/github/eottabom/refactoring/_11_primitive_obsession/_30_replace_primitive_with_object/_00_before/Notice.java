package io.github.eottabom.refactoring._11_primitive_obsession._30_replace_primitive_with_object._00_before;

public class Notice {

	private String level; // ex: "normal", "urgent", "emergency"

	public Notice(String level) {
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

}
