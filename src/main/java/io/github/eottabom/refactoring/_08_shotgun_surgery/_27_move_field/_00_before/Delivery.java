package io.github.eottabom.refactoring._08_shotgun_surgery._27_move_field._00_before;

import java.time.LocalDateTime;

public class Delivery {

	private LocalDateTime scheduledDate;

	public Delivery(LocalDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

}
