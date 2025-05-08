package io.github.eottabom.refactoring._08_shotgun_surgery._29_inline_class;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ReportTests {

	@Test
	void reportSummary() {
		// @formatter:off
		// STEP 5) 이제는 ReportDetail 을 사용할 필요가 없어지므로 제거해준다.
//		Report report = new Report(new ReportDetail("alice", "bob", "Inappropriate language"));
		Report report = new Report("alice", "bob", "Inappropriate language");
		// @formatter:on

		assertThat(report.getReportSummary()).isEqualTo("alice reported bob for: Inappropriate language");
	}

}
