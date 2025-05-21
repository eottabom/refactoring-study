package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate._00_before;

import java.time.LocalDateTime;

public class SuiteReservation extends RoomReservation {

	private SuitePackage suitePackage;

	public SuiteReservation(Room room, LocalDateTime checkInDateTime, SuitePackage suitePackage) {
		super(room, checkInDateTime);
		this.suitePackage = suitePackage;
	}

	@Override
	public boolean includesLateCheckout() {
		return this.room.hasAmenity("lateCheckout");
	}

	@Override
	public double calculateRate() {
		return Math.round(super.calculateRate() + this.suitePackage.getExtraCharge());
	}

	public boolean includesDinnerService() {
		return this.suitePackage.hasAmenity("dinner") && !isWeekend();
	}

}
