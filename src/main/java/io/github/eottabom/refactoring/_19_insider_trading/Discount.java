package io.github.eottabom.refactoring._19_insider_trading;

import java.time.LocalDate;

public class Discount {

	// 사실 이 기능을 Member 쪽으로 옮겨도 상관은 없다.
	public boolean isDiscountTarget(Member member) {
		LocalDate cutOffDate = LocalDate.of(2022, 1, 1);
		return member.isPremium() && member.getJoinDate().isBefore(cutOffDate);
	}

}
