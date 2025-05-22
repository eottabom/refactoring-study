package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate;

// STEP 1) add
public class SuiteDelegate {

	private RoomReservation roomReservation;

	private SuitePackage suitePackage;

	public SuiteDelegate(RoomReservation roomReservation, SuitePackage suitePackage) {
		this.roomReservation = roomReservation;
		this.suitePackage = suitePackage;
	}

	// STEP 3) 이 부분을 delegate 쪽으로 옮겨준다.
	public boolean includesLateCheckout() {
		return this.roomReservation.room.hasAmenity("lateCheckout");
	}

	// @formatter:off
	/*
		STEP 5) add
		여기서 계산 하는 로직은 SuiteReservation 의 calculateRate 의 로직이 된다.
		그렇게 되면, calculateRate 은 더이상 필요가 없어진다.
	 */
	// @formatter:on
	public double extendBasePrice(double rate) {
		return Math.round(rate + this.suitePackage.getExtraCharge());
	}

	// STEP 6) move
	public boolean includesDinnerService() {
		return this.suitePackage.hasAmenity("dinner") && !this.roomReservation.isWeekend();
	}
}
