package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoomReservationTests {

	@Test
	void baseRateOnWeekday() {
		Room room = new Room(List.of(), 120);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

		RoomReservation standard = RoomReservation.createReservation(room, weekday);
		assertThat(standard.calculateRate()).isEqualTo(120);

		SuitePackage suitePackage = new SuitePackage(List.of(), 50);
		RoomReservation suite = RoomReservation.createSuiteReservation(room, weekday, suitePackage);
		assertThat(suite.calculateRate()).isEqualTo(170);
	}

	@Test
	void baseRateOnWeekendWithSurcharge() {
		Room room = new Room(List.of(), 120);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

		RoomReservation standard = RoomReservation.createReservation(room, weekend);
		assertThat(standard.calculateRate()).isEqualTo(138);

		SuitePackage suitePackage = new SuitePackage(List.of(), 50);
		RoomReservation suite = RoomReservation.createSuiteReservation(room, weekend, suitePackage);
		assertThat(suite.calculateRate()).isEqualTo(188);
	}

	@Test
	void lateCheckoutAvailability() {
		Room room = new Room(List.of(), 120);
		Room withLateCheckout = new Room(List.of("lateCheckout"), 120);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
		SuitePackage suitePackage = new SuitePackage(List.of(), 50);

		// @formatter:off
		// 여기서 생성자 대신에 팩토리 메서드를 사용한다.
//		assertThat(new RoomReservation(room, weekday).includesLateCheckout()).isFalse();
//		assertThat(new RoomReservation(withLateCheckout, weekday).includesLateCheckout()).isTrue();
//		assertThat(new RoomReservation(withLateCheckout, weekend).includesLateCheckout()).isFalse();

		assertThat(RoomReservation.createReservation(room, weekday).includesLateCheckout()).isFalse();
		assertThat(RoomReservation.createReservation(withLateCheckout, weekday).includesLateCheckout()).isTrue();
		assertThat(RoomReservation.createReservation(withLateCheckout, weekend).includesLateCheckout()).isFalse();

//		assertThat(new SuiteReservation(withLateCheckout, weekend, suitePackage).includesLateCheckout()).isTrue();

		// @formatter:on
		assertThat(RoomReservation.createSuiteReservation(withLateCheckout, weekend, suitePackage).includesLateCheckout()).isTrue();
	}

	@Test
	void dinnerServiceAvailability() {
		Room room = new Room(List.of(), 120);
		SuitePackage suiteWithDinner = new SuitePackage(List.of("dinner"), 50);
		LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
		LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

		// @formatter:off
		/*
			STEP 6) 우선은 여기를 팩토리 메서드를 사용해준다.
			그러면 SuiteReservation 에서만 includesDinnerService 가 있어서, 컴파일 에러가 나는데,
			includesDinnerService 를 pull up 해준다.
		 */
		// @formatter:on
		assertThat(RoomReservation.createSuiteReservation(room, weekday, suiteWithDinner).includesDinnerService()).isTrue();
		assertThat(RoomReservation.createSuiteReservation(room, weekend, suiteWithDinner).includesDinnerService()).isFalse();
	}

}
