package io.github.eottabom.refactoring._06_mutable_data._21.replace_derived_variable_with_query;

import java.util.ArrayList;
import java.util.List;

public class ProductionPlan {

	// @formatter:off
//	private double production; // 이 변수가 사실 derived variable 변수가 되는 것이다.

	private List<Double> adjustments = new ArrayList<>();

	public void applyAdjustment(double adjustment) {
		this.adjustments.add(adjustment);
//		this.production += adjustment; // 이 과정은 불필요해진다.
	}


	public double getProduction() {
//		assert this.production == calculatedProduction(); // add
//		return this.production;

		// 최종적으로 이렇게 하면 된다.
		return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
	}

	private double calculatedProduction() {
//		return this.adjustments.stream().reduce((double) 0, (a, b) -> a + b);
		return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
	}
	// @formatter:on
}

