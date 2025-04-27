package io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier._02;

import java.util.List;

public class MonsterTracker {

	// @formatter:off
	// 이 녀석은 알림만 할 수 있게 수정하고, 별도의 메서드로 find 하는 메서드를 수정한다.
	// 이렇게 나누었더니 중복된 for 문이 있는데 이것도 변경할 수 있다.
//	public String alertForDangerousMonster(List<Monster> monsters) {
	public void alertForDangerousMonster(List<Monster> monsters) {
		for (Monster m : monsters) {
			if (m.getName().equals("Dragon")) {
				triggerAlarm();
//				return "Dragon";
			}

			if (m.getName().equals("Demon Lord")) {
				triggerAlarm();
//				return "Demon Lord";
			}
		}
//		return "";
		// 이렇게 알고리즘을 변경할 수도 있다.
		if (!findDangerousMonster(monsters).isBlank()) {
			triggerAlarm();
		}
	}

	public String findDangerousMonster(List<Monster> monsters) {
		for (Monster m : monsters) {
			if (m.getName().equals("Dragon")) {
				triggerAlarm();
				return "Dragon";
			}

			if (m.getName().equals("Demon Lord")) {
				triggerAlarm();
				return "Demon Lord";
			}
		}
		return "";
	}

	private void triggerAlarm() {
		System.out.println("Danger! Monster detected!");
	}

	// @formatter:on
}
