package io.github.eottabom.refactoring._08_shotgun_surgery._29_inline_class._00_before;

public class Report {

	private ReportDetail reportDetail;

	public Report(ReportDetail reportDetail) {
		this.reportDetail = reportDetail;
	}

	public ReportDetail getReportDetail() {
		return this.reportDetail;
	}

	public void setReportDetail(ReportDetail reportDetail) {
		this.reportDetail = reportDetail;
	}

	public String getReportSummary() {
		return this.reportDetail.summary();
	}

}
