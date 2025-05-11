package io.github.eottabom.refactoring._11_primitive_obsession._30_replace_primitive_with_object;

import java.util.List;

public class NoticeManager {

	public long countUrgentNotices(List<Notice> notices) {
		return notices.stream()
//			.filter((n) -> "urgent".equals(n.getLevel()) || "emergency".equals(n.getLevel()))
			.filter((n) -> n.getLevel().urgentThan(new Level("urgent")))
			.count();
	}

}
