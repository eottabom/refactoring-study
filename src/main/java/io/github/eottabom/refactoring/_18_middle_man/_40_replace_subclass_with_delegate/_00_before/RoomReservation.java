package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate._00_before;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class RoomReservation {

	protected Room room;

	protected LocalDateTime checkInDateTime;

	public RoomReservation(Room room, LocalDateTime checkInDateTime) {
		this.room = room;
		this.checkInDateTime = checkInDateTime;
	}

	public boolean includesLateCheckout() {
		return this.room.hasAmenity("lateCheckout") && !isWeekend();
	}

	protected boolean isWeekend() {
		DayOfWeek day = this.checkInDateTime.getDayOfWeek();
		return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
	}

	public double calculateRate() {
		double rate = this.room.getBaseRate();
		if (isWeekend()) {
			rate += Math.round(rate * 0.15);
		}
		return rate;
	}

}
