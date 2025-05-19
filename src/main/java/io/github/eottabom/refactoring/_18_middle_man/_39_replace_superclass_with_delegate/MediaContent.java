package io.github.eottabom.refactoring._18_middle_man._39_replace_superclass_with_delegate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

// @formatter:off
// remove extends
public class MediaContent { //extends ContentItem {

	private final LocalDate dateLastReviewed;

	// STEP 1) add 필드 선언하고, 그 필드로 선언한 인스턴스를 만들어준다.
	private final ContentItem contentItem;

	public MediaContent(int id, String title, List<String> genres, LocalDate dateLastReviewed) {
		// STEP 2) remove
//		super(id, title, genres);
		this.dateLastReviewed = dateLastReviewed;
		// add
		this.contentItem = new ContentItem(id, title, genres);
	}

	public long daysSinceLastReview(LocalDate targetDate) {
		return this.dateLastReviewed.until(targetDate, ChronoUnit.DAYS);
	}
// @formatter:on
}
