package io.github.eottabom.refactoring._08_shotgun_surgery._29_inline_class;

// STEP 6) 최종적으로 이 클래스를 제거할 수 있다.
public class ReportDetail {

	// @formatter:off
	/*
		메서드들 부터 옮기수는 있지만, 필드들 먼저 옮겨도 된다.
		STEP 1) 필드 이동 + 생성자 이동ㄴ
	 */
//	private String reporter;
//
//	private String reportedUser;
//
//	private String reason;
//
//	public ReportDetail(String reporter, String reportedUser, String reason) {
//		this.reporter = reporter;
//		this.reportedUser = reportedUser;
//		this.reason = reason;
//	}

	/*
		STEP 2) 메서드 이동
	 */
//	public String summary() {
//		return this.reporter + " reported " + this.reportedUser + " for: " + this.reason;
//	}
//
//	public String getReporter() {
//		return this.reporter;
//	}
//
//	public void setReporter(String reporter) {
//		this.reporter = reporter;
//	}
//
//	public String getReportedUser() {
//		return this.reportedUser;
//	}
//
//	public void setReportedUser(String reportedUser) {
//		this.reportedUser = reportedUser;
//	}
//
//	public String getReason() {
//		return this.reason;
//	}
//
//	public void setReason(String reason) {
//		this.reason = reason;
//	}

	// @formatter:on
}
