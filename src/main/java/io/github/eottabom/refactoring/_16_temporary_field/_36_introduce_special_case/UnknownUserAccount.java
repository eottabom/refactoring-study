package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case;

// STEP 1) 그리고 UserAccount 를 상속 받는다.
public class UnknownUserAccount extends UserAccount {

	// STEP 2) Unknown 인 경우에는 plan, delinquencyHistory 는 null 로 세팅해주게 한다.
	public UnknownUserAccount() {
//		super("unknown", null, null);
		// STEP 8) 여기도 마찬가지다. defaultPlan 을 UnknownUserAccount 에서 디폴트 값으로 new DefaultPlan() 을 세팅해주면 여기서 판단할게 아니게 된다.
//		super("unknown", new DefaultPlan(), null);
		// STEP 9) Null Object Pattern
		super("unknown", new DefaultPlan(), new NullDelinquencyHistory());
	}

	// STEP 4) 여기서는 항상 true 가 된다.
	@Override
	public boolean isUnknown() {
		return true;
	}

	// STEP 6) UnknownUserAccount 에서 getUserName 을 오버라이드해서 수정한다.
	@Override
	public String getUsername() {
		return "unknown";
	}
}

