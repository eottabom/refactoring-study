package io.github.eottabom.refactoring._03_long_function._10_replace_function_with_command;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {

	public Participant(String username) {
		this(username, new HashMap<>());
	}

	public double getRate(double totalNumberOfEvents) {
		long count = this.homework.values().stream().filter((value) -> value).count();
		return count * 100 / totalNumberOfEvents;
	}

	public void setHomeworkDone(int index) {
		this.homework.put(index, true);
	}
}
