package io.github.eottabom.refactoring._06_mutable_data._18_split_variable;

public class GameCharacter {

	private final double baseSpeed;

	private final double buffedSpeed;

	private final double weight;

	private final int buffActivationTime;

	public GameCharacter(double baseSpeed, double buffedSpeed, double weight, int buffActivationTime) {
		this.baseSpeed = baseSpeed;
		this.buffedSpeed = buffedSpeed;
		this.weight = weight;
		this.buffActivationTime = buffActivationTime;
	}

	// @formatter:off
	/*
		acceleration 라는 변수는 두 번 사용되는데,
		첫 번째는 거리를 구하는데 필요한 변수, 
		두 번째는 추진력으로 이동한 거리인 변수
		final 키워드를 써도 좋다.
	 */
	// @formatter:on
	public double moveDistance(int elapsedTime) {
		double distance;
		// AS-IS
		// double acceleration = this.baseSpeed / this.weight;
		// TO-BE
		final double baseAcceleration = this.baseSpeed / this.weight;
		int normalPhaseTime = Math.min(elapsedTime, this.buffActivationTime);
		// AS-IS
		// distance = 0.5 * acceleration * normalPhaseTime * normalPhaseTime;
		// TO-BE
		distance = 0.5 * baseAcceleration * normalPhaseTime * normalPhaseTime;

		int buffPhaseTime = elapsedTime - this.buffActivationTime;
		if (buffPhaseTime > 0) {
			// AS-IS
			// double velocityAtBuff = acceleration * this.buffActivationTime;
			// TO-BE
			final double velocityAtBuff = baseAcceleration * this.buffActivationTime;
			// AS-IS
			// acceleration = (this.baseSpeed + this.buffedSpeed) / this.weight;
			final double buffAcceleration = (this.baseSpeed + this.buffedSpeed) / this.weight;
			// distance += velocityAtBuff * buffPhaseTime + 0.5 * acceleration * buffPhaseTime * buffPhaseTime;
			distance += velocityAtBuff * buffPhaseTime + 0.5 * buffAcceleration * buffPhaseTime * buffPhaseTime;
		}

		return distance;
	}

}
