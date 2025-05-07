package io.github.eottabom.refactoring._07_divergent_change._25_move_function;

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
//			basePenalty += this.calculateFatiguePenalty();
			basePenalty += this.classType.calculateFatiguePenalty(this.fatigueDays);
		}
		return basePenalty;
	}

	public int getFatigueDays() {
		return this.fatigueDays;
	}

	// @formatter:off
	/*
		이 메서드 위치는 반반이긴하다.
		fatigueDays 는 Character 에 속한 것이고, isElite 는 ClassType 에 속한 것이라서,
		어느 정도 반반으로 보이긴하다.
		하지만, ClassType 에 있는 데이터를 사용하고 있으므로, ClassType 으로 이동시켜본다.
		옮기면 fatigueDays 라는 데이터를 참조하고 있고 전달 받아야한다.
		아래 메서드에서 fatigueDays 외에 다른 데이터들도 참조한다면 Character 를 매개변수로 넘기는 것이 타당하다.
		하지만, fatigueDays 만 남겨주므로 int 의 fatigueDays 값만 넘겨주면된다.
	 */
	// @formatter:on
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
