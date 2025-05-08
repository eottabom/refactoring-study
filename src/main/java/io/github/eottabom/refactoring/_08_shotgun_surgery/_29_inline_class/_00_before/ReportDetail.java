package io.github.eottabom.refactoring._08_shotgun_surgery._29_inline_class._00_before;

public class ReportDetail {

	private String reporter;

	private String reportedUser;

	private String reason;

	public ReportDetail(String reporter, String reportedUser, String reason) {
		this.reporter = reporter;
		this.reportedUser = reportedUser;
		this.reason = reason;
	}

	public String summary() {
		return this.reporter + " reported " + this.reportedUser + " for: " + this.reason;
	}

	public String getReporter() {
		return this.reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getReportedUser() {
		return this.reportedUser;
	}

	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
