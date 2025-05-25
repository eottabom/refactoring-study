package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;

public interface NotificationService {

	// STEP 1) 추상 메서드를 하나 만들기.
	void sendNotification(Notification notification);

}
