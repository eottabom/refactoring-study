package io.github.eottabom.refactoring._13_loop._33_replace_loop_with_pipeline;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private final String team;

	private final String slackId;

	public Employee(String team, String slackId) {
		this.team = team;
		this.slackId = slackId;
	}

	public static List<String> slackIdsByTeam(List<Employee> employees, String team) {
		var result = new ArrayList<String>();
		for (Employee e : employees) {
			if (e.team.equals(team)) {
				if (e.slackId != null) {
					result.add(e.slackId);
				}
			}
		}
		return result;
	}

}
