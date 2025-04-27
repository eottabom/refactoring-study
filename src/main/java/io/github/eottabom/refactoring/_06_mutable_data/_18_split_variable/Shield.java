package io.github.eottabom.refactoring._06_mutable_data._18_split_variable;

public class Shield {

	private double durability;

	private double coverage;

	// @formatter:off
	/*
		temp 라는 변수는 본인의 역할을 잘 하고 있는가..? 라는 생각을 해봐야한다.
		리팩토링을 하고 나면 기존의 Test 코드가 정상 동작하는지 확인해봐야한다.
	 */
	// @formatter:on
	public void updateShield(double height, double width) {
		// 여기서는 durability 를 의미하고
		// AS-IS
		// double temp = 2 * (height + width);
		// TO-BE
		double durability = 2 * (height + width);
		System.out.println("Shield Durability: " + durability);
		// AS-IS
		// this.durability = temp;
		// TO-BE
		this.durability = durability;

		// 여기서는 coverage 를 의미하는데, 변수를 바꾸어주어도 된다.
		// AS-IS
		// temp = height * width;
		// TO-BE
		double coverage = height * width;
		System.out.println("Shield Coverage Area: " + coverage);
		// AS-IS
		// this.coverage = temp;
		// TO-BE
		this.coverage = coverage;
	}

	public double getDurability() {
		return this.durability;
	}

	public double getCoverage() {
		return this.coverage;
	}

}
