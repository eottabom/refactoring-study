package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case;

public class SubscriptionSite {

	private final UserAccount userAccount;

	public SubscriptionSite(UserAccount userAccount) {
		// STEP 5) 여기서 판단해준다.
		this.userAccount = userAccount.getUsername().equals("unknown") ? new UnknownUserAccount() : userAccount;
//		this.userAccount = userAccount;
	}

	public UserAccount getUserAccount() {
		return this.userAccount;
	}

}
