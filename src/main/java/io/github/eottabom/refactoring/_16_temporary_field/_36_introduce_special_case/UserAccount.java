package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case;

public class UserAccount {

	private String username;

	private Plan plan;

	private DelinquencyHistory delinquencyHistory;

	public UserAccount(String username, Plan plan, DelinquencyHistory delinquencyHistory) {
		this.username = username;
		this.plan = plan;
		this.delinquencyHistory = delinquencyHistory;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public DelinquencyHistory getDelinquencyHistory() {
		return this.delinquencyHistory;
	}

	public void setDelinquencyHistory(DelinquencyHistory delinquencyHistory) {
		this.delinquencyHistory = delinquencyHistory;
	}

	// STEP 4) method 를 하고 여기는 Special case 가 아니므로 항상 false 가 되게 해주고
	public boolean isUnknown() {
		return false;
	}
}
