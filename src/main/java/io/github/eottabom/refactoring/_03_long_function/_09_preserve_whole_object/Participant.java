package io.github.eottabom.refactoring._03_long_function._09_preserve_whole_object;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {

	public Participant(String username) {
		this(username, new HashMap<>());
	}

	// 이 메서드가 생겼다고 볼 수 있고,
	// Participant 레코드는 점점 더 발전하면 클래스로 바뀔 수도 있다.
	public double getRate(double totalNumberOfEvents) {
		long count = this.homework.values().stream().filter((value) -> value).count();
		return count * 100 / totalNumberOfEvents;
	}

	public void setHomeworkDone(int index) {
		this.homework.put(index, true);
	}
}
;