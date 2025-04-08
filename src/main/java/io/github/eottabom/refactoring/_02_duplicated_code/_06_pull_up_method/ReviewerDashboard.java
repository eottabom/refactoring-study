package io.github.eottabom.refactoring._02_duplicated_code._06_pull_up_method;

public class ReviewerDashboard extends Dashboard {

	// @formatter:off
	/*
		step1)
		ParticipantDashboard 와 완전히 같지는 않은데,
		ParticipantDashboard 에서의 메서드는 파라미터를 받게 되어 있고,
		그래서 메서드를 전체추출해서 파라미터를 줄 수 있게 변경 할 수 있다.
	 */
	// @formatter:on
	public void printReviewers() {
		super.printUserNames(30);
	}

	// @formatter:off
	/*
		step2)
		변수이름은 reviewers 보다는 이제는 userNames 가 더 맞게 된다.
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
