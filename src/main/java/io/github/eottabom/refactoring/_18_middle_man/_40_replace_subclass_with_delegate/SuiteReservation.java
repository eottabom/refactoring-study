package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.LocalDateTime;

public class SuiteReservation extends RoomReservation {

	private SuitePackage suitePackage;

	public SuiteReservation(Room room, LocalDateTime checkInDateTime, SuitePackage suitePackage) {
		super(room, checkInDateTime);
		this.suitePackage = suitePackage;
	}

	// @formatter:off
	/*
		STEP 3) 이 부분을 delegate 쪽으로 옮겨준다.
		실제 로직은 SuitePackage includesLateCheckout 메서드로 옮겨진거고,
		이 메서드는 이제 중재자 역할을 하게 된다.
		이 녀석은 단순히 위임만 하게 되는 것이다.
	 */
	// STEP 4) remove includesLateCheckout method
//	@Override
//	public boolean includesLateCheckout() {
////		return this.room.hasAmenity("lateCheckout");
//		return this.suiteDelegate.includesLateCheckout();
//	}
	// @formatter:on

	@Override
	public double calculateRate() {
		return Math.round(super.calculateRate() + this.suitePackage.getExtraCharge());
	}

	public boolean includesDinnerService() {
		return this.suitePackage.hasAmenity("dinner") && !isWeekend();
	}

}
