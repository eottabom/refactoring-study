package io.github.eottabom.refactoring._13_loop._33_replace_loop_with_pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

	private final String team;

	private final String slackId;

	public Employee(String team, String slackId) {
		this.team = team;
		this.slackId = slackId;
	}

	// @formatter:off
	public static List<String> slackIdsByTeam(List<Employee> employees, String team) {
		var result = new ArrayList<String>();
		// 아주 일반적이다. 하지만 콜렉션 파이프라인을 사용하게 되면 코드가 더 명확해진다.
		// 지금은 코드를 굉장히 자세히 봐야 눈에 들어온다.
		for (Employee e : employees) {
			if (e.team.equals(team)) {
				var id = e.slackId; // 이건 map 이라는 Operation 으로 변경가능
				if (id != null) {
					result.add(id);
				}
			}
		}

		// STEP 1) if 문을 변경해본다.
//		employees.stream().filter(new Predicate<Employee>() {
//			@Override
//			public boolean test(Employee employee) {
//				return employee.team.equals(team);
//			}
//		});
//		return result;

		// STEP 1) 또는 람다 익스프레션이로 적용
		return employees.stream().filter((e) -> e.team.equals(team))
				// STEP 2) map Operation 으로 변경
				.map((e) -> e.slackId)
				// STEP 3) if 문을 다시 filter 로
				.filter((id) -> id != null)
				// collect 로 변경
				.collect(Collectors.toList());
	}
	// @formatter:on

}
