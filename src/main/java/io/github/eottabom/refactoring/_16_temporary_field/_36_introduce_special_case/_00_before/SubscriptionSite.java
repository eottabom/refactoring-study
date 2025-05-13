package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case._00_before;

public class SubscriptionSite {

	private final UserAccount userAccount;

	public SubscriptionSite(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

}
