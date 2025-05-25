package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces._00_before;

public class ReservationAlerts {

	private AlertService alertService;

	public ReservationAlerts(AlertService alertService) {
		this.alertService = alertService;
	}

	public void alertConfirmed(Reservation reservation) {
		AlertMessage alertMessage = new AlertMessage();
		alertMessage.setMessage(reservation.toString() + " is confirmed");
		alertMessage.setFor(reservation.getEmail());
		this.alertService.add(alertMessage);
	}

}
