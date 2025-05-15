package io.github.eottabom.refactoring._17_message_chains._37_hide_delegate._00_before;

public class Guild {

	private String guildCode;

	private Character leader;

	public Guild(String guildCode, Character leader) {
		this.guildCode = guildCode;
		this.leader = leader;
	}

	public String getGuildCode() {
		return this.guildCode;
	}

	public void setGuildCode(String guildCode) {
		this.guildCode = guildCode;
	}

	public Character getLeader() {
		return this.leader;
	}

	public void setLeader(Character leader) {
		this.leader = leader;
	}
}
