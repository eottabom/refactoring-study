package io.github.eottabom.refactoring._20_large_class._41_extract_superclass._00_before;

import java.util.List;

public class StudentGroup {

	private String name;

	private List<Student> members;

	public String getName() {
		return this.name;
	}

	public List<Student> getMembers() {
		return this.members;
	}

	public double totalMonthlyFee() {
		return this.members.stream().mapToDouble(Student::getMonthlyFee).sum();
	}

	public double totalAnnualFee() {
		return this.totalMonthlyFee() * 12;
	}

	public int memberCount() {
		return this.members.size();
	}

}
