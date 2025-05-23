package io.github.eottabom.refactoring._20_large_class._41_extract_superclass._00_before;

public class Student {

	private Integer id;

	private String name;

	private double monthlyFee;

	public double annualFee() {
		return this.monthlyFee * 12;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getMonthlyFee() {
		return this.monthlyFee;
	}

}
