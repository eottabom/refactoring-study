package io.github.eottabom.refactoring._12_repeated_switches;

public class DiscountPolicy {

	public int discountRate(String grade) {
		int result;
		// 이것은 전형적인 switch 문이다.
		switch (grade) {
			case "vip":
				result = 30;
				break;
			case "premium":
				result = 15;
				break;
			case "basic":
				result = 5;
				break;
			default:
				result = 0;
		}
		return result;
	}

	public int discountRate2(String grade) {
		// 이것은 전형적인 switch expression 이다.
		return switch (grade) {
			case "vip" -> 30;
			case "premium" -> 15;
			case "basic" -> 5;
			default -> 0;
		};
	}

	public int discountRate3(String grade) {
		// 이것은 전형적인 switch expression 에서도 ": yield " 을 쑬 수 있다,
		// "->" 가 그냥 ": yield " 라고 생각 하면 된다.
		return switch (grade) {
			case "vip" : yield 30;
			case "premium" : yield 15;
			case "basic" : yield 5;
			default : yield 0;
		};
	}

}
