package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

// STEP 3) add
public class EmailNotificationService implements NotificationService {

	private EmailService emailService;

	// 이렇게하면 추상화를 한단계를 올린 것이다.
	@Override
	public void sendNotification(Notification notification) {
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTitle(notification.getTitle() + " is ready for check-in");
		emailMessage.setTo(notification.getReceiver());
		emailMessage.setFrom(notification.getSender());
		this.emailService.sendEmail(emailMessage);
	}
}
