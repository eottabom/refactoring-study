package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

public class Reservation {

	public String getEmail() {
		return "guest@email.com";
	}

	@Override
	public String toString() {
		return "Reservation #4455";
	}

}
