package io.github.eottabom.refactoring._23_refused_bequest._00_before;

public class GameCharacter {

	protected SkillSet skillSet;

	protected SkillSet getSkillSet() {
		return new SkillSet();
	}

}
