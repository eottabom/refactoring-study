package io.github.eottabom.refactoring._18_middle_man._39_replace_superclass_with_delegate._00_before;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MediaContent extends ContentItem {

	private final LocalDate dateLastReviewed;

	public MediaContent(int id, String title, List<String> genres, LocalDate dateLastReviewed) {
		super(id, title, genres);
		this.dateLastReviewed = dateLastReviewed;
	}

	public long daysSinceLastReview(LocalDate targetDate) {
		return this.dateLastReviewed.until(targetDate, ChronoUnit.DAYS);
	}

}
