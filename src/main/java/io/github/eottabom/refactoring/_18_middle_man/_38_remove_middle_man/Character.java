package io.github.eottabom.refactoring._18_middle_man._38_remove_middle_man;

public class Character {

	private String name;

	private Guild guild;

	public Character(String name, Guild guild) {
		this.name = name;
		this.guild = guild;
	}

	// @formatter:off
	// remove
//	public Character getLeader() {
//		return this.guild.getLeader();
//	}
	// @formatter:on

	// add
	public Guild getGuild() {
		return this.guild;
	}
}
