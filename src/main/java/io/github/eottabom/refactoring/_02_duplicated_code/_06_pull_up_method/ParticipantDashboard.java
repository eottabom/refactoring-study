package io.github.eottabom.refactoring._02_duplicated_code._06_pull_up_method;

public class ParticipantDashboard extends Dashboard {

	// @formatter:off
	/*
		step3)
		ReviewerDashboard 가 변경되었으니,
		여기도 동일한 구조로 변경할 수 있다.
		printParticipants -> printUserNames
	 */
//	public void printUserNames(int postId) {
//		var post = PostFactory.getPost(postId);
//
//		Set<String> userNames = new HashSet<>();
//		post.comments().forEach(comment -> userNames.add(comment.userName()));
//
//		userNames.forEach(System.out::println);
//	}
	// @formatter:on

}
