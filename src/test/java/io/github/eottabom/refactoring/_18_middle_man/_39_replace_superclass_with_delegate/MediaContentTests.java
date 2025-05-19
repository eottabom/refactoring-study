package io.github.eottabom.refactoring._18_middle_man._39_replace_superclass_with_delegate;

import java.time.LocalDate;

import io.github.eottabom.refactoring._18_middle_man._39_replace_superclass_with_delegate._00_before.MediaContent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MediaContentTests {

	@Test
	void daysSinceLastReview() {
		MediaContent content = new MediaContent(1, "Inception", null, LocalDate.of(2022, 1, 10));
		assertThat(content.daysSinceLastReview(LocalDate.of(2022, 1, 15))).isEqualTo(5);
	}

}
