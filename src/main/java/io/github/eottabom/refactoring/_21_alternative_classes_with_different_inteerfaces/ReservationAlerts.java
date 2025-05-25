package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

public class ReservationAlerts {

	private AlertService alertService;

	private AlertNotificationService alertNotificationService;

	public ReservationAlerts(//AlertService alertService,
			AlertNotificationService alertNotificationService) {
//		this.alertService = alertService;
		this.alertNotificationService = alertNotificationService;
	}

	public void alertConfirmed(Reservation reservation) {
		Notification notification = Notification.newNotification(reservation.toString() + " is confirmed")
				.receiver(reservation.getEmail());
		this.alertNotificationService.sendNotification(notification);
//		AlertMessage alertMessage = new AlertMessage();
//		alertMessage.setMessage(reservation.toString() + " is confirmed");
//		alertMessage.setFor(reservation.getEmail());
//		this.alertService.add(alertMessage);
	}

//	public void alertConfirmed(Notification notification) {
//		AlertMessage alertMessage = new AlertMessage();
//		alertMessage.setMessage(reservation.toString() + " is confirmed");
//		alertMessage.setFor(reservation.getEmail());
//		this.alertService.add(alertMessage);
//	}

}
