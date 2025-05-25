package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

public final class Notification {

	private String title;

	private String receiver;

	private String sender;

	private Notification(String title) {
		this.title = title;
	}

	public static Notification newNotification(String title) {
		return new Notification(title);
	}

	public Notification receiver(String receiver) {
		this.receiver = receiver;
		return this;
	}

	public Notification sender(String sender) {
		this.sender = sender;
		return this;
	}

	public String getTitle() {
		return this.title;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public String getSender() {
		return this.sender;
	}

}
