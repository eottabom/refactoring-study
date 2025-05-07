package io.github.eottabom.refactoring._07_divergent_change._25_move_function;

public class ClassType {

	private boolean elite;

	public ClassType(boolean elite) {
		this.elite = elite;
	}

	public boolean isElite() {
		return this.elite;
	}

	public void setElite(boolean elite) {
		this.elite = elite;
	}

	double calculateFatiguePenalty(int fatigueDays) {
		if (this.isElite()) {
			final int baseFatigue = 5;
			if (fatigueDays <= 3) {
				return baseFatigue;
			}
			else {
				return baseFatigue + (fatigueDays - 3) * 1.2;
			}
		}
		else {
			return fatigueDays * 2.0;
		}
	}

}
