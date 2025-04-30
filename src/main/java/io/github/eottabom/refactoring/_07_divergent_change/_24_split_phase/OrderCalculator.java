package io.github.eottabom.refactoring._07_divergent_change._24_split_phase;

public class OrderCalculator {

	// @formatter:off
	public double calculateOrderPrice(MenuItem menuItem, int quantity, DeliveryOption deliveryOption) {
		// STEP 4) 이 부분도 별도의 메서드로 빼낸다.
//		final double basePrice = menuItem.unitPrice() * quantity;
//
//		final double discount = (quantity >= menuItem.discountThreshold()) ? basePrice * menuItem.discountRate() : 0.0;
//		// STEP 2) 중간 데이터 생성 (intermediate Data)
//		final PriceData priceData = new PriceData(basePrice, discount, quantity);

		final PriceData priceData = getPriceData(menuItem, quantity);

		// STEP 1) 메서드로 분리
//		final double deliveryFee = (basePrice >= deliveryOption.freeThreshold()) ? 0.0
//				: deliveryOption.feePerDelivery();

		// STEP 3)
		// deliveryFee 의 매개변수를 보면 basePrice, discount, quantity 는 값과 관련된 데이터이므로, PriceData 값을 넘겨주게 변경한다.
		// 사실 quantity 는 매개변수로 그냥 넘겨도 상관 없음. 하기 나름.
//		final double price = deliveryFee(basePrice, deliveryOption, discount);

		// STEP 5) inline 리팩토링 할 부분은 해도 된다.
		return deliveryFee(priceData, deliveryOption);
	}

	private static PriceData getPriceData(MenuItem menuItem, int quantity) {
		final double basePrice = menuItem.unitPrice() * quantity;
		final double discount = (quantity >= menuItem.discountThreshold()) ? basePrice * menuItem.discountRate() : 0.0;
		return new PriceData(basePrice, discount, quantity);
	}

//	public double deliveryFee(double basePrice, DeliveryOption deliveryOption, double discount) {
//		final double deliveryFee = (basePrice >= deliveryOption.freeThreshold()) ? 0.0 : deliveryOption.feePerDelivery();
//		final double price = basePrice - discount + deliveryFee;
//		return price;
//	}

	private double deliveryFee(PriceData priceData, DeliveryOption deliveryOption) {
		final double deliveryFee = (priceData.basePrice() >= deliveryOption.freeThreshold()) ? 0.0 : deliveryOption.feePerDelivery();
		final double deliveryCost = priceData.quantity() * deliveryFee;
		return priceData.basePrice() - priceData.discount() + deliveryCost;
	}

	// @formatter:on

}
