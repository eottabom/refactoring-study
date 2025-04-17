package io.github.eottabom.refactoring._04_long_parameter_list._16_combine_functions_into_class._00_before;

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
