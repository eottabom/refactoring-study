package io.github.eottabom.refactoring._20_large_class._41_extract_superclass;

import java.util.List;

public class StudentGroup extends Participant {

	// STEP 2 ) pull up
	// @formatter: off
	// pull up
//	private String name;

	private List<Student> members;

//	public String getName() {
//		return this.name;
//	}
	// @formatter: on

	// add
	public StudentGroup(String name) {
		super(name);
	}

	public List<Student> getMembers() {
		return this.members;
	}

	public double totalMonthlyFee() {
		return this.members.stream().mapToDouble(Student::getMonthlyFee).sum();
	}

//	// STEP 3) pull up
//	public double totalAnnualFee() {
//		return this.totalMonthlyFee() * 12;
//	}

	public int memberCount() {
		return this.members.size();
	}

}
