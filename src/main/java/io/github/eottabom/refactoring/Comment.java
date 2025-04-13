package io.github.eottabom.refactoring;

import java.time.LocalDateTime;

public class Comment {

	private final String userName;

	private final String content;

	private final LocalDateTime createAt;

	public Comment(String userName, String content) {
		this(userName, content, LocalDateTime.now());
	}

	public Comment(String userName, String content, LocalDateTime createAt) {
		this.userName = userName;
		this.content = content;
		this.createAt = createAt;
	}

	public String userName() {
		return this.userName;
	}

	public String content() {
		return this.content;
	}

	public LocalDateTime createAt() {
		return this.createAt;
	}
}
