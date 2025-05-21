package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoomReservationTests {

	@Test
	void shouldReturnBaseRateOnWeekdayForStandardRoom() {
		Room room = new Room(List.of(), 120);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

		RoomReservation reservation = new RoomReservation(room, weekday);
		assertThat(reservation.calculateRate()).isEqualTo(120);
	}

	@Test
	void shouldIncludeSuiteFeeOnWeekday() {
		Room room = new Room(List.of(), 120);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
		SuitePackage suitePackage = new SuitePackage(List.of(), 50);

		SuiteReservation reservation = new SuiteReservation(room, weekday, suitePackage);
		assertThat(reservation.calculateRate()).isEqualTo(170);
	}

	@Test
	void shouldAddWeekendSurchargeToBaseRate() {
		Room room = new Room(List.of(), 120);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

		RoomReservation reservation = new RoomReservation(room, weekend);
		assertThat(reservation.calculateRate()).isEqualTo(138);
	}

	@Test
	void shouldIncludeSuiteFeeOnWeekendWithSurcharge() {
		Room room = new Room(List.of(), 120);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
		SuitePackage suitePackage = new SuitePackage(List.of(), 50);

		SuiteReservation reservation = new SuiteReservation(room, weekend, suitePackage);
		assertThat(reservation.calculateRate()).isEqualTo(188);
	}

	@Test
	void shouldEnableLateCheckoutOnWeekdayOnly() {
		Room roomWithLateCheckout = new Room(List.of("lateCheckout"), 120);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

		assertThat(new RoomReservation(roomWithLateCheckout, weekday).includesLateCheckout()).isTrue();
		assertThat(new RoomReservation(roomWithLateCheckout, weekend).includesLateCheckout()).isFalse();
	}

	@Test
	void shouldEnableLateCheckoutForSuiteEvenOnWeekend() {
		Room roomWithLateCheckout = new Room(List.of("lateCheckout"), 120);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
		SuitePackage suitePackage = new SuitePackage(List.of(), 50);

		SuiteReservation reservation = new SuiteReservation(roomWithLateCheckout, weekend, suitePackage);
		assertThat(reservation.includesLateCheckout()).isTrue();
	}

	@Test
	void shouldProvideDinnerServiceOnlyOnWeekdays() {
		Room room = new Room(List.of(), 120);
		SuitePackage suiteWithDinner = new SuitePackage(List.of("dinner"), 50);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

		assertThat(new SuiteReservation(room, weekday, suiteWithDinner).includesDinnerService()).isTrue();
		assertThat(new SuiteReservation(room, weekend, suiteWithDinner).includesDinnerService()).isFalse();
	}

}
