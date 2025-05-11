package io.github.eottabom.refactoring._11_primitive_obsession._30_replace_primitive_with_object;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoticeManagerTests {

	@Test
	void countUrgentNotices() {
		NoticeManager noticeManager = new NoticeManager();
		// @formatter:off
		long urgentCount = noticeManager.countUrgentNotices(
				List.of(
//						new Notice("normal"),
//						new Notice("urgent"),
//						new Notice("emergency"),
//						new Notice("normal")
						new Notice(new Level("normal")),
						new Notice(new Level("urgent")),
						new Notice(new Level("emergency")),
						new Notice(new Level("normal"))
				)
		);
		// @formatter:on

		assertThat(urgentCount).isEqualTo(2);
	}

}
