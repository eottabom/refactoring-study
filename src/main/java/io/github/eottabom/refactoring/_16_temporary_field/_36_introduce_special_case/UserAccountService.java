package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case;

public class UserAccountService {

	// @formatter:off
	/*
		STEP 1)
		여기서 account.getUsername().equals("unknown") 인 경우가 계속해서 반복하고 있는데,
		이 Special case 를 클래스로 추출한다.
	 */

	public String displayName(SubscriptionSite site) {
		// STEP 7) 그러면 여기서 site.getUserAccount().getUsername() 만 호출해주면 된다.
		return site.getUserAccount().getUsername();

		// 사실은 account 에서 이제 unknown 인지 아닌지 판단을 할 수 있다.
//		UserAccount account = site.getUserAccount();

//		String userName;
		// STEP 3)
//		if (account.getUsername().equals("unknown")) {
//		if (account.isUnknown()) {
			// unknown 이면 unknown 을 리턴해주게 할 수 있는데,
			// STEP 6) UnknownUserAccount 클래스에서 getUserName 을 오버라이드해서 처리할 수 있다.
//			userName = "unknown";
//		}
//		else {
//			userName = account.getUsername();
//		}
//		return userName;
	}

	public Plan determinePlan(SubscriptionSite site) {
//		UserAccount account = site.getUserAccount();
		// STEP 8) 여기도 마찬가지다. defaultPlan 을 UnknownUserAccount 에서 디폴트 값으로 new DefaultPlan() 을 세팅해주면 여기서 판단할게 아니게 된다.
		return site.getUserAccount().getPlan();
//		return account.isUnknown() ? new DefaultPlan() : account.getPlan();
		// STEP 3)
//		return isUnknown(account) ? new DefaultPlan() : account.getPlan();
//		return account.getUsername().equals("unknown") ? new DefaultPlan() : account.getPlan();
	}

	public int overdueWeeks(SubscriptionSite site) {
		UserAccount account = site.getUserAccount();
		// STEP 10) 이렇게 수정할 수 있다.
		return site.getUserAccount().getDelinquencyHistory().getWeeksOverdueLastYear();

		// STEP 9) 여기서는 Null Object Pattern 을 적용해줄 수 있다.
		// Add NullDelinquencyHistory 클래스를 만들어준다.
//		return account.isUnknown() ? 0 : account.getDelinquencyHistory().getWeeksOverdueLastYear();
		// STEP 3)
//		return account.getUsername().equals("unknown") ? 0 : account.getDelinquencyHistory().getWeeksOverdueLastYear();
	}

	// STEP 3) 반복적인 account.getUsername().equals("unknown") 를 Extract Method 로 추출한다.
	// 이렇게 빼내니깐 이녀석이 여기에 있는게 맞는가 생각해보면, UserAccount 쪽에 위치하는게 더 적합해보인다.
	// STEP 4) move method
//	private static boolean isUnknown(UserAccount account) {
//		return account.getUsername().equals("unknown");
//	}
	// @formatter:on

}
