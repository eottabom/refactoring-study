package io.github.eottabom.refactoring._19_insider_trading._00_before;

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
}
