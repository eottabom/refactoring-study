package io.github.eottabom.refactoring._06_mutable_data._21.replace_derived_variable_with_query;

public class Discount {

	// @formatter:off
//	private double disCountedTotal; // 이 변수는 사실 derived variable 이다. 파생된, 계산된 변수.

	private double discount;

	private double baseTotal;

	public Discount(double baseTotal) {
		this.baseTotal = baseTotal;
	}

	public double getDisCountedTotal() {
//		assert this.disCountedTotal == this.baseTotal - this.discount; // add
//		return this.disCountedTotal;
		return this.baseTotal - this.discount; // 이렇게 변경 할 수 있고, disCountedTotal 변수를 지울 수도 있다.
	}

	public void setDiscount(double number) {
		this.discount = number;
//		this.disCountedTotal = this.baseTotal - this.discount;
	}

//	this.baseTotal - this.discount -> 이것을 하나의 메서드로 빼주어도 된다.
	private double calDiscountedTotal() {
		return this.baseTotal - this.discount;
	}
	// @formatter:on
}
