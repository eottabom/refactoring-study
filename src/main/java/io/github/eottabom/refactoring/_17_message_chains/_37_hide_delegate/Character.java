package io.github.eottabom.refactoring._17_message_chains._37_hide_delegate;

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

	// @formatter:off
	/*
		테스트 코드를 보면, archer.getGuild().getLeader(); 이런 부분이 있는데,
		getGuild().getLeader() 로 체이닝해서 가져오게 하지 않고,
		character 에서 Leader 정보를 내려주게 한다.
		따라서, character getLeader 메서드를 추가해준다.

		사실 지금은 Extract Function 와 move method 를 해서,
		Hide Delegate 리팩토링을 한 것이다.

		만약에 getGuild().getLeader() 를 하지 않고(getGuild 를 거치지 않고, 사용한다면)

		클라이언트 코드는 변경될 사항이 없다.

		ex)
		private Character leader;

		public Character getLeader() {
			return this.leader;
		}

		이런 부분이 Hide Delegate 의 가치인 것이다.
	 */
	// @formatter:on
	public Character getLeader() {
		return getGuild().getLeader();
	}
}
