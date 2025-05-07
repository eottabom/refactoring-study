package io.github.eottabom.refactoring._07_divergent_change._25_move_function._00_before;

public class Character {

	private final int fatigueDays;

	private final ClassType classType;

	public Character(int fatigueDays, ClassType classType) {
		this.fatigueDays = fatigueDays;
		this.classType = classType;
	}

	public double getRestPenalty() {
		double basePenalty = 2.0; // 기본 피로도 패널티
		if (this.getFatigueDays() > 0) {
			basePenalty += this.calculateFatiguePenalty();
		}
		return basePenalty;
	}

	public int getFatigueDays() {
		return this.fatigueDays;
	}

	private double calculateFatiguePenalty() {
		if (this.classType.isElite()) {
			final int baseFatigue = 5;
			if (this.fatigueDays <= 3) {
				return baseFatigue;
			}
			else {
				return baseFatigue + (this.fatigueDays - 3) * 1.2;
			}
		}
		else {
			return this.fatigueDays * 2.0;
		}
	}

}
