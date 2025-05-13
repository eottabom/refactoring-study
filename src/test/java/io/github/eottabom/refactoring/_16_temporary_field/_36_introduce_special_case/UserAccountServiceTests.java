package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UserAccountServiceTests {

	UserAccountService userAccountService = new UserAccountService();

	UserAccount unknownUser = new UserAccount("unknown", null, null);

	Plan eottabomPlan = new Plan();

	UserAccount eottabom = new UserAccount("eottabom", this.eottabomPlan, new DelinquencyHistory(1));

	@Test
	void displayName_returnsCorrectName() {
		String unknownName = this.userAccountService.displayName(new SubscriptionSite(this.unknownUser));
		assertThat(unknownName).isEqualTo("unknown");

		String knownName = this.userAccountService.displayName(new SubscriptionSite(this.eottabom));
		assertThat(knownName).isEqualTo("eottabom");
	}

	@Test
	void determinePlan_returnsCorrectPlan() {
		Plan unknownPlan = this.userAccountService.determinePlan(new SubscriptionSite(this.unknownUser));
		assertThat(unknownPlan).isInstanceOf(DefaultPlan.class);

		Plan actualPlan = this.userAccountService.determinePlan(new SubscriptionSite(this.eottabom));
		assertThat(actualPlan).isEqualTo(this.eottabomPlan);
	}

	@Test
	void overdueWeeks_returnsCorrectWeeks() {
		int overdueWeeks = this.userAccountService.overdueWeeks(new SubscriptionSite(this.eottabom));
		assertThat(overdueWeeks).isEqualTo(1);

		int unknownWeeks = this.userAccountService.overdueWeeks(new SubscriptionSite(this.unknownUser));
		assertThat(unknownWeeks).isEqualTo(0);
	}

}
