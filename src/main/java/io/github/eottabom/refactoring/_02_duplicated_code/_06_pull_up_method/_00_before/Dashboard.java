package io.github.eottabom.refactoring._02_duplicated_code._06_pull_up_method._00_before;

public class Dashboard {

	public static void main(String[] args) {
		ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
		reviewerDashboard.printReviewers();

		ParticipantDashboard participantDashboard = new ParticipantDashboard();
		participantDashboard.printParticipants(15);
	}
}
