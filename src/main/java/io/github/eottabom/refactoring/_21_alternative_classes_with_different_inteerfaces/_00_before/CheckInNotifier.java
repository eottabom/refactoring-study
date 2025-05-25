package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces._00_before;

public class CheckInNotifier {

	private EmailService emailService;

	public CheckInNotifier(EmailService emailService) {
		this.emailService = emailService;
	}

	public void notifyCheckIn(CheckInInfo info) {
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTitle(info.getReservation() + " is ready for check-in");
		emailMessage.setTo(info.getEmail());
		emailMessage.setFrom("frontdesk@hotel.com");
		this.emailService.sendEmail(emailMessage);
	}

}
