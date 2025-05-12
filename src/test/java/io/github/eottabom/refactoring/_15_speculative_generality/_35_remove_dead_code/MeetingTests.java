package io.github.eottabom.refactoring._15_speculative_generality._35_remove_dead_code;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MeetingTests {

	@Test
	void meetingNotification() {
		Meeting meeting = new Meeting("Refactoring Session", LocalDateTime.of(2022, 1, 20, 19, 30),
				LocalDateTime.of(2022, 1, 20, 21, 0));

		meeting.scheduleNotification(30);

		assertThat(meeting.getNotifyAt()).isEqualTo(LocalDateTime.of(2022, 1, 20, 19, 0));
	}

}
