package io.github.eottabom.refactoring._24_comments._43_introduce_assertion;

public class Coupon {

	private Double discountPercent;

	public double applyDiscount(double amount) {
		// amount 는 음수가 아니라고 가정하고 있는 것이다.
		return (this.discountPercent != null) ? amount - (this.discountPercent * amount) : amount;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
//		assert discountPercent != null && discountPercent > 0; // 최초에 설정할 때 음수가 아니라고 선언할 수 있음.
		// 이런 조건은 이렇게 쓰는게 더 적절할 수 있음.
		if (discountPercent != null && discountPercent > 0) {
			throw new IllegalArgumentException("Discount percent must be zero or positive");
		}
		this.discountPercent = discountPercent;
	}

}
