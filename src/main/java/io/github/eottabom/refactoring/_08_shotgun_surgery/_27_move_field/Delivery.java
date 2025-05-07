package io.github.eottabom.refactoring._08_shotgun_surgery._27_move_field;

import java.time.LocalDateTime;

public class Delivery {

	private LocalDateTime scheduledDate;

	// STEP 3) 변수 추가
	private double rate;

	// STEP 3) 매개변수 추가
	public Delivery(LocalDateTime scheduledDate, double rate) {
		this.scheduledDate = scheduledDate;
		this.rate = rate;
	}

	// STEP 4) setter / getter 추가
	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
