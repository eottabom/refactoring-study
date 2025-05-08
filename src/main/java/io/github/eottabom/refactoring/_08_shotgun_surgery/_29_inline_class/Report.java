package io.github.eottabom.refactoring._08_shotgun_surgery._29_inline_class;

public class Report {

	// @formatter:off
	// STEP 3) 그렇게 되면 ReportDetail 를 사용하는 필드들을 제거할 수 있다.

	// STEP 3) remove
//	private ReportDetail reportDetail;

	// add
	private String reporter;

	// add
	private String reportedUser;

	// add
	private String reason;

	// STEP 3) remove
//	public Report(ReportDetail reportDetail) {
//		this.reportDetail = reportDetail;
//	}

	// 생성자를 만들어준다.
	public Report(String reporter, String reportedUser, String reason) {
		this.reporter = reporter;
		this.reportedUser = reportedUser;
		this.reason = reason;
	}

	// STEP 3) remove
//	public ReportDetail getReportDetail() {
//		return this.reportDetail;
//	}

	// STEP 3) remove
//	public void setReportDetail(ReportDetail reportDetail) {
//		this.reportDetail = reportDetail;
//	}

	// 여기는 inline function 을 통해서 수정 할 수 있다.
	public String getReportSummary() {
		// STEP 4) Inline function
//		return this.reportDetail.summary();
		return this.reporter + " reported " + this.reportedUser + " for: " + this.reason;
	}

	// STEP 2) move method (ReportDetail -> Report)
	// STEP 4) Inline function
//	public String summary() {
//		return this.reporter + " reported " + this.reportedUser + " for: " + this.reason;
//	}

	// STEP 2) move method (ReportDetail -> Report)
	public String getReporter() {
		return this.reporter;
	}

	// STEP 2) move method (ReportDetail -> Report)
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	// STEP 2) move method (ReportDetail -> Report)
	public String getReportedUser() {
		return this.reportedUser;
	}

	// STEP 2) move method (ReportDetail -> Report)
	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}

	// STEP 2) move method (ReportDetail -> Report)
	public String getReason() {
		return this.reason;
	}

	// STEP 2) move method (ReportDetail -> Report)
	public void setReason(String reason) {
		this.reason = reason;
	}
	// @formatter:on

}
