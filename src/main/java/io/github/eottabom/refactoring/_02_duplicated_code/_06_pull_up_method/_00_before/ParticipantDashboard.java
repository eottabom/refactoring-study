package io.github.eottabom.refactoring._02_duplicated_code._06_pull_up_method._00_before;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring._02_duplicated_code.factory.PostFactory;

public class ParticipantDashboard extends Dashboard {

	public void printParticipants(int postId) {
		var post = PostFactory.getPost(postId);

		Set<String> participants = new HashSet<>();
		post.comments().forEach(comment -> participants.add(comment.userName()));

		participants.forEach(System.out::println);
	}

}
