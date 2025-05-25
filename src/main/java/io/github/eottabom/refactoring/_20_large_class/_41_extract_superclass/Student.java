package io.github.eottabom.refactoring._20_large_class._41_extract_superclass;

public class Student extends Participant {

	private Integer id;

	// STEP 2 ) pull up
	// @formatter: off
	// pull up
//	private String name;

	private double monthlyFee;

	// add
	public Student(String name) {
		super(name);
	}

	// STEP 3) pull up
	// STEP 5) 이제는 이 코드는 없어도 된다.
//	public double annualFee() {
//		return this.monthlyFee * 12;
//	}

	public Integer getId() {
		return this.id;
	}

//	public String getName() {
//		return this.name;
//	}
	// @formatter: on

	// STEP 4) override
	@Override
	public double getMonthlyFee() {
		return this.monthlyFee;
	}

}
