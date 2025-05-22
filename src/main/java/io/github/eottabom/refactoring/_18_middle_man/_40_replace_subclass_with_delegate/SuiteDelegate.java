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
}
