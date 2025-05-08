package io.github.eottabom.refactoring._08_shotgun_surgery._28_inline_function._00_before;

public class Student {

	private final int skippedHomework;

	public Student(int skippedHomework) {
		this.skippedHomework = skippedHomework;
	}

	public int getSkippedHomework() {
		return this.skippedHomework;
	}
}
