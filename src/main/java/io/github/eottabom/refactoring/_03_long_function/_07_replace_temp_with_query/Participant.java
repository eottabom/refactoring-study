package io.github.eottabom.refactoring._03_long_function._07_replace_temp_with_query;

import java.util.HashMap;
import java.util.Map;

public record Participant(String username, Map<Integer, Boolean> homework) {

	public Participant(String username) {
		this(username, new HashMap<>());
	}

	public double getRate(double total) {
		long count = this.homework.values().stream().filter((value) -> value).count();
		return count * 100 / total;
	}

	public void setHomeworkDone(int index) {
		this.homework.put(index, true);
	}
}
