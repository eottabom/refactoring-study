package io.github.eottabom.refactoring._06_mutable_date._19_separate_query_from_modifier._02;

import java.util.List;

import io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier._02.Monster;
import io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier._02.MonsterTracker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonsterTrackerTests {

	// @formatter:off
	@Test
	void alertForDangerousMonster() {
		MonsterTracker monsterTracker = new MonsterTracker();
//		String found =  monsterTracker.alertForDangerousMonster(List.of(new Monster("Dragon"), new Monster("Demon Lord")));
		String found =  monsterTracker.findDangerousMonster(List.of(new Monster("Dragon"), new Monster("Demon Lord")));
		assertThat(found).isEqualTo("Dragon");

//		found = monsterTracker.alertForDangerousMonster(List.of(new Monster("Demon Lord"), new Monster("Dog")));
		found = monsterTracker.findDangerousMonster(List.of(new Monster("Demon Lord"), new Monster("Dog")));
		assertThat(found).isEqualTo("Demon Lord");

//		found = monsterTracker.alertForDangerousMonster(List.of(new Monster("Dog"), new Monster("Cat")));
		found = monsterTracker.findDangerousMonster(List.of(new Monster("Dog"), new Monster("Cat")));
		assertThat(found).isEqualTo("");
	}
	// @formatter:on

}
