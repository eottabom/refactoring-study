package io.github.eottabom.refactoring._02_duplicated_code._05_slide_statements;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class PostDashBoard {

	/*
		어떠한 변수를 사용하기 바로 직전에 사용하는 분들이 있기도하고,
		처음에 변수를 사용하는 분들이 있기도하다.
		하지만, 책의 저자인 마틴 파울러는 변수를 사용하기 바로 직전에 사용하는 것을 선호한다.
		그래야 한 블럭으로 코드를 볼 수 있기 때문이다.
		문맥의 혼동이 있기 때문에 변수를 사용하기 전에 사용하는 것이 좋다.
		-> 코드를 읽기도 쉽고, 코드 관리도 쉽고, 함수 추출하기도 쉬워진다.
	 */
	public void printParticipants(int postId) {
		// Get post
		// Set<String> participants = new HashSet<>();
		var post = PostFactory.getPost(postId);

		// Get participants
		Set<String> participants = new HashSet<>();
		post.comments().forEach(comment -> participants.add(comment.userName()));

		// Print participants
		participants.forEach(System.out::println);
	}

	public void printReviewers() {
		// Get post
		// Set<String> reviewers = new HashSet<>();
		var post = PostFactory.getPost(30);

		// Get reviewers
		Set<String> reviewers = new HashSet<>();
		post.comments().forEach(comment -> reviewers.add(comment.userName()));

		// Print reviewers
		reviewers.forEach(System.out::println);
	}

	public static void main(String[] args) {
		PostDashBoard dashboard = new PostDashBoard();
		dashboard.printReviewers();
		dashboard.printParticipants(15);
	}
}
