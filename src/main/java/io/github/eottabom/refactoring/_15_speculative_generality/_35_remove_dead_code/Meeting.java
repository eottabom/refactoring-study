package io.github.eottabom.refactoring._15_speculative_generality._35_remove_dead_code;

import java.time.LocalDateTime;

public class Meeting {
	// 인텔리제이에서 usage 를 볼 수 있는데 그거 보고 테스트 코드에서만 사용한다~ 라는게 보이니 과감히 이 클래스 제거!
	private String topic;

	private LocalDateTime start;

	private LocalDateTime end;

	private LocalDateTime notifyAt;

	public Meeting(String topic, LocalDateTime start, LocalDateTime end) {
		this.topic = topic;
		this.start = start;
		this.end = end;
	}

	public void scheduleNotification(int minutesBefore) {
		this.notifyAt = this.start.minusMinutes(minutesBefore);
	}

	public LocalDateTime getNotifyAt() {
		return this.notifyAt;
	}
}
