package io.github.eottabom.refactoring._02_duplicated_code._04_extract_function;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring.Post;
import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class PostDashBoard {

	/*
		"의도" 와 "구현" 관점에서 생각한다면,
		이 코드는 "구현" 에 가깝다고 할 수 있을 것이다.
	 */
	public void printParticipants(Post post) {
		// Get participants
		Set<String> participants = new HashSet<>();
		post.comments().forEach(comment -> participants.add(comment.userName()));

		// Print participants
		participants.forEach(System.out::println);
	}

	public void printReviewers(Post post) {
		// Get reviewers
		Set<String> reviewers = new HashSet<>();
		post.comments().forEach(comment -> reviewers.add(comment.userName()));

		// Print reviewers
		reviewers.forEach(System.out::println);
	}

	public static void main(String[] args) {
		PostDashBoard dashboard = new PostDashBoard();

		var participantPost = PostFactory.getPost(15);
		var reviewerPost = PostFactory.getPost(30);

		dashboard.printParticipants(participantPost);
		dashboard.printReviewers(reviewerPost);
	}
}
