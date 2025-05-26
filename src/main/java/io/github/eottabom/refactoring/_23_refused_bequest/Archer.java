package io.github.eottabom.refactoring._23_refused_bequest;

public class Archer extends GameCharacter {

	protected SkillSet skillSet;

	protected SkillSet getSkillSet() {
		return new SkillSet();
	}
}
