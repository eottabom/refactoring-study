package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

public class AlertNotificationService implements NotificationService {

	private AlertService alertService;

	public AlertNotificationService(AlertService alertService) {
		this.alertService = alertService;
	}

	@Override
	public void sendNotification(Notification notification) {
		AlertMessage alertMessage = new AlertMessage();
		alertMessage.setMessage(notification.toString() + " is confirmed");
		alertMessage.setFor(notification.getReceiver());
		this.alertService.add(alertMessage);
	}
}
