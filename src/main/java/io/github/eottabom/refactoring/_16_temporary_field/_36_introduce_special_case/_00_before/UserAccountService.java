package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case._00_before;

public class UserAccountService {

	public String displayName(SubscriptionSite site) {
		UserAccount account = site.getUserAccount();

		String userName;
		if (account.getUsername().equals("unknown")) {
			userName = "unknown";
		}
		else {
			userName = account.getUsername();
		}
		return userName;
	}

	public Plan determinePlan(SubscriptionSite site) {
		UserAccount account = site.getUserAccount();
		return account.getUsername().equals("unknown") ? new DefaultPlan() : account.getPlan();
	}

	public int overdueWeeks(SubscriptionSite site) {
		UserAccount account = site.getUserAccount();
		return account.getUsername().equals("unknown") ? 0 : account.getDelinquencyHistory().getWeeksOverdueLastYear();
	}

}
