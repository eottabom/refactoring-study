package io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDateTime;

public class Message {

	private final LocalDateTime requestAt;

	private final String channel;

	public Message(LocalDateTime requestAt, String channel) {
		this.requestAt = requestAt;
		this.channel = channel;
	}

	public LocalDateTime getRequestAt() {
		return this.requestAt;
	}

	public String getChannel() {
		return this.channel;
	}

}
