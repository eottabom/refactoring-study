package io.github.eottabom.refactoring._24_comments._43_introduce_assertion._00_before;

public class Coupon {

	private Double discountPercent;

	public double applyDiscount(double amount) {
		return (this.discountPercent != null) ? amount - (this.discountPercent * amount) : amount;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

}
