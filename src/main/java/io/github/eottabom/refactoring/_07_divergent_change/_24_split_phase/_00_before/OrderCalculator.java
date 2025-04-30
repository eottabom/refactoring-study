package io.github.eottabom.refactoring._07_divergent_change._24_split_phase._00_before;

public class OrderCalculator {

	public double calculateOrderPrice(MenuItem menuItem, int quantity, DeliveryOption deliveryOption) {
		final double basePrice = menuItem.unitPrice() * quantity;

		final double discount = (quantity >= menuItem.discountThreshold()) ? basePrice * menuItem.discountRate() : 0.0;

		final double deliveryFee = (basePrice >= deliveryOption.freeThreshold()) ? 0.0
				: deliveryOption.feePerDelivery();

		return basePrice - discount + deliveryFee;
	}

}
