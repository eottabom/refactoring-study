package io.github.eottabom.refactoring._02_duplicated_code._06_pull_up_method._00_before;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class ReviewerDashboard extends Dashboard {

	public void printReviewers() {
		var post = PostFactory.getPost(30);

		Set<String> reviewers = new HashSet<>();
		post.comments().forEach((comment) -> reviewers.add(comment.userName()));

		reviewers.forEach(System.out::println);
	}

}
