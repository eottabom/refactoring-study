package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case._00_before;

public class DelinquencyHistory {

	private final int weeksOverdueLastYear;

	public DelinquencyHistory(int weeksOverdueLastYear) {
		this.weeksOverdueLastYear = weeksOverdueLastYear;
	}

	public int getWeeksOverdueLastYear() {
		return this.weeksOverdueLastYear;
	}

}
