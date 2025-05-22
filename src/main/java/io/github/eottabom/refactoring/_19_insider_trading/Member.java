package io.github.eottabom.refactoring._19_insider_trading;

import java.time.LocalDate;

public class Member {

	private LocalDate joinDate;

	private boolean premium;

	public Member(LocalDate joinDate, boolean premium) {
		this.joinDate = joinDate;
		this.premium = premium;
	}

	public LocalDate getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isPremium() {
		return this.premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	// add 이렇게 되면 로직이 좀 더 간단해 진다.
	public boolean isDiscountTarget() {
		LocalDate cutOffDate = LocalDate.of(2022, 1, 1);
		return isPremium() && getJoinDate().isBefore(cutOffDate);
	}
}
