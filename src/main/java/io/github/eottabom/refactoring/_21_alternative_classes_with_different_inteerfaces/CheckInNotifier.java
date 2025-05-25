package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

public class CheckInNotifier {

	private EmailService emailService;

	private NotificationService notificationService;

	public CheckInNotifier(//EmailService emailService,
			NotificationService notificationService) {
//		this.emailService = emailService;
		this.notificationService = notificationService;
	}

	// STEP 2) add 메서드로 하나 빼준다.
	public void notifyCheckIn(CheckInInfo info) {
		Notification notification = Notification.newNotification(info.getReservation())
						.receiver(info.getEmail())
						.sender("frontdesk@hotel.com");
		sendNotification(notification);
		// STEP 4) inline method
		this.notificationService.sendNotification(notification);
	}

	// STEP 2) 메서드로 하나 빼고, 매개 변수를 CheckInInfo info 에서 Notification 으로 바꾼다
//	public void notifyCheckIn(CheckInInfo info) {
	public void sendNotification(Notification notification) {
		// STEP 4) EmailNotificationService 클래스를 만들어서 감싸주었기 때문에 inline method 로 코드를 줄 일 수 있다.
//		this.notificationService.sendNotification(notification);
		// 아래 부분을 notificationService 의 sendNotification 로 변경해 줄 수 있다.
//		EmailMessage emailMessage = new EmailMessage();
//		emailMessage.setTitle(info.getReservation() + " is ready for check-in");
//		emailMessage.setTo(info.getEmail());
//		emailMessage.setFrom("frontdesk@hotel.com");
//		this.emailService.sendEmail(emailMessage);
	}

}
