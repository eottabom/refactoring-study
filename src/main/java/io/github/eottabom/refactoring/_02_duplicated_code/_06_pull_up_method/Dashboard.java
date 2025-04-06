package io.github.eottabom.refactoring._02_duplicated_code._06_pull_up_method;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class Dashboard {

	public static void main(String[] args) {
		ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
		reviewerDashboard.printReviewers();

		ParticipantDashboard participantDashboard = new ParticipantDashboard();
		participantDashboard.printUserNames(15);
	}

	/*
		step4)
		pull up method 를 통해서,
		하위 클래스에 있는 printUserNames 메서드들을 상위 클래스인 Dashboard 로 올릴 수 있다.
		(인텔리제에서는 refactor -> pull members up 이었음 / 문맥에 따라서 이름이 달라짐)
	 */
	public void printUserNames(int postId) {
		var post = PostFactory.getPost(postId);

		Set<String> userNames = new HashSet<>();
		post.comments().forEach(comment -> userNames.add(comment.userName()));

		userNames.forEach(System.out::println);
	}
}
