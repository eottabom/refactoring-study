package io.github.eottabom.refactoring._06_mutable_data._18_split_variable;

public class GameStore {

	// @formatter:off
	/*
		메서드의 매개 변수가 재사용되는 경우가 있는데,
		이것도 역시 두가지 의미로 사용되고 있다.
		처음에 전달된 값, 이 안에서 사용되는 값
	 */
	// @formatter:on
	public double applyPromotion(double basePrice, int purchaseCount) {
		double result = basePrice; // 추가적인 변수를 작성하고 쓰는것이 좋다.
		if (basePrice > 50) {
			// basePrice -= 2;
			result -= 2;
		}
		if (purchaseCount > 100) {
			// basePrice -= 1;
			result -= 1;
		}
		// return basePrice;
		return result;
	}

}
