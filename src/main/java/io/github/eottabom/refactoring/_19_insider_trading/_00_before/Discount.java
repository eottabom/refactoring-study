package io.github.eottabom.refactoring._19_insider_trading._00_before;

import java.time.LocalDate;

public class Discount {

	public boolean isDiscountTarget(Member member) {
		LocalDate cutOffDate = LocalDate.of(2022, 1, 1);
		return member.isPremium() && member.getJoinDate().isBefore(cutOffDate);
	}

}
