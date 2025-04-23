package io.github.eottabom.refactoring._06_mutable_data._18_split_variable;

public class GameStore {

	public double applyPromotion(double basePrice, int purchaseCount) {
		if (basePrice > 60) {
			basePrice -= 7;
		}
		if (purchaseCount > 3) {
			basePrice -= 5;
		}
		return basePrice;
	}

}
