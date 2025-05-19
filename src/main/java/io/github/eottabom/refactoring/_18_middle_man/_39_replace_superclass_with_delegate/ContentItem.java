package io.github.eottabom.refactoring._18_middle_man._39_replace_superclass_with_delegate;

import java.util.List;

public class ContentItem {

	private final int id;

	private final String title;

	private final List<String> genres;

	public ContentItem(int id, String title, List<String> genres) {
		this.id = id;
		this.title = title;
		this.genres = genres;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean hasGenre(String genre) {
		return this.genres.contains(genre);
	}

}
