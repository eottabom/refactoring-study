package io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier._01;

import io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier.Item;
import io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier.Player;

public class Manager {

	private final Player player;

	private final NotificationSystem notificationSystem;

	public Manager(Player player, NotificationSystem notificationSystem) {
		this.player = player;
		this.notificationSystem = notificationSystem;
	}

	// 이 메서드는 2가지 일을 하고 있다.
	// 전체 값을 계산하고 notify 를 하고 있다.
//	public double getTotalLootAndNotify() {
	public double getTotalLoot() {
		double total = this.player.getInventory().stream().map(Item::getValue).reduce(0.0, Double::sum);
		// notifyLootSummary();
		return total;
	}

	// 이 메서드를 public 으로 변경해주고, getTotalLootAndNotify 메서드 이름을 변경하고 바로 return 하면된다.
	//private void notifyLootSummary() {
	public void notifyLootSummary() {
		notificationSystem.notify(formatLootSummary(this.player));
	}

	private String formatLootSummary(Player player) {
		return "Loot summary for " + player.getName();
	}

}
