package io.github.eottabom.refactoring._20_large_class._41_extract_superclass;

// STEP 1) add Participant
public class Participant {

	protected String name;

	public Participant(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// STEP 3) pull up
//	public double totalAnnualFee() {
//		return this.totalMonthlyFee() * 12;
//	}
}
