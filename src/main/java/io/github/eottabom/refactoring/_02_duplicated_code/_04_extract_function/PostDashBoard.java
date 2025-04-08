package io.github.eottabom.refactoring._02_duplicated_code._04_extract_function;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring.Post;
import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class PostDashBoard {

	// @formatter:off
	/*
		"의도" 와 "구현" 관점에서 생각한다면,
		이 코드는 "구현" 에 가깝다고 할 수 있을 것이다.
		코드가 한 번에 잘 읽히지 않는다.
		함수를 추출하고 나서는 코드의 주석이 필요 없다.
		printParticipants 와 printReviewers 도 리팩토링을 할 수 있을 것이다. (나중에 다룬다.)
	 */
	// @formatter:on
	public void printParticipants(int postId) {
		var post = getPost(postId);
		Set<String> participants = getUserNames(post);
		print(participants);
	}

	public void printReviewers() {
		var post = getPost(30);
		Set<String> reviewers = getUserNames(post);
		print(reviewers);
	}

	// 중복된 Get post 부분을 메서드로 추출
	private Post getPost(int postId) {
		return PostFactory.getPost(postId);
	}

	// 중복된 Get participants, reviewers -> userNames 을 가져오는 부분을 메서드로 추출
	private Set<String> getUserNames(Post post) {
		// participants -> userNames 가 이 메서드 안에서는 더 맞는 표현이므로, 변경한다.
		Set<String> userNames = new HashSet<>();
		post.comments().forEach((comment) -> userNames.add(comment.userName()));
		return userNames;
	}

	// 중복된 print 하는 부분을 메서더르로 추출
	private void print(Set<String> userNames) {
		userNames.forEach(System.out::println);
	}

	public static void main(String[] args) {
		PostDashBoard dashboard = new PostDashBoard();
		dashboard.printReviewers();
		dashboard.printParticipants(15);
	}

}
