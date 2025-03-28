package io.github.eottabom.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Article {

	private final String title;

	private final List<Comment> comments = new ArrayList<>();

	public Article(String title) {
		this.title = title;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return this.comments;
	}

}
