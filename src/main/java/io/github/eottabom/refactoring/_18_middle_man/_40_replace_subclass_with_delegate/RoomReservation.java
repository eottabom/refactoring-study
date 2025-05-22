package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

// @formatter:off
/*
	RoomReservation 이 있고, SuiteRoomReservation 가 있는데,
	SuiteRoomReservation 에서만 사용하는 특별한 로직들이 있는데,
	이것은 사실 상속의 적절한 예시일 수 있다.

	STEP 1)
	SuiteReservation 를 제거하기 위해서는
	SuiteDelegate 라는 클래스를 만들어준다. 위임할 수 있는 delegate 를 만드는 것.
 */
// @formatter:on
public class RoomReservation {

	protected Room room;

	protected LocalDateTime checkInDateTime;

	// @formatter:off
	/*
		STEP 2) add factory method

		why 팩토리 메서드를 쓰는가?
		일단, 메서드 이름을 자유롭게 만들 수 있다는 것. -> 다양하게 표현을 할 수 있다.
		또한, 리턴하는 객체의 타입이 조금 더 자유롭다.
		-> 하위 클래스인 서브 클래스인 상속구조를 활용해서 리턴하는 것도 가능하다.
	 */
	// @formatter:on
	protected SuiteDelegate suiteDelegate;

	// 이 생성자 대신에 static 한 메서드를 사용한다. (factory method)
	public RoomReservation(Room room, LocalDateTime checkInDateTime) {
		this.room = room;
		this.checkInDateTime = checkInDateTime;
	}

	public static RoomReservation createReservation(Room room, LocalDateTime checkInDateTime) {
		return new RoomReservation(room, checkInDateTime);
	}

	public static RoomReservation createSuiteReservation(Room room, LocalDateTime checkInDateTime,
			SuitePackage suitePackage) {
		// @formatter:off
		// 하위 클래스인 서브 클래스인 상속구조를 활용해서 리턴하는 것도 가능하다.
//		return new SuiteReservation(room, checkInDateTime, suitePackage);
		// @formatter:on

		// 우선은 SuiteReservation 을 그대로 사용하되, delegate 를 중간에 사용하게 한다.
		var suiteReservation = new SuiteReservation(room, checkInDateTime, suitePackage);
		suiteReservation.suiteDelegate = new SuiteDelegate(suiteReservation, suitePackage); // 중요!
		return suiteReservation;
	}

	// 여기도 수정이 가능하다.
	// STEP 4) 로직은 delegate 쪽으로 이동했으니, 이제는 여기서 결정을 하면된다.
	// 이렇게 되면 SuiteReservation 에서 includesLateCheckout 는 없어도 된다.
	public boolean includesLateCheckout() {
		// return this.room.hasAmenity("lateCheckout") && !isWeekend();
		return (this.suiteDelegate != null) ? this.suiteDelegate.includesLateCheckout()
				: this.room.hasAmenity("lateCheckout") && !isWeekend();
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
		return (this.suiteDelegate != null) ? this.suiteDelegate.extendBasePrice(rate);
	}

}
