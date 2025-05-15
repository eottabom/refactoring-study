package io.github.eottabom.refactoring._17_message_chains._37_hide_delegate._00_before;

public class Character {

	private String name;

	private Guild guild;

	public Character(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Guild getGuild() {
		return this.guild;
	}

	public void setGuild(Guild guild) {
		this.guild = guild;
	}

}
