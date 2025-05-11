package io.github.eottabom.refactoring._12_repeated_switches;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DiscountPolicyTests {

	@Test
	void discountRate() {
		DiscountPolicy policy = new DiscountPolicy();
		assertThat(policy.discountRate("vip")).isEqualTo(30);
		assertThat(policy.discountRate("premium")).isEqualTo(15);
		assertThat(policy.discountRate("basic")).isEqualTo(0);
		assertThat(policy.discountRate("unknown")).isEqualTo(0);
	}

}
