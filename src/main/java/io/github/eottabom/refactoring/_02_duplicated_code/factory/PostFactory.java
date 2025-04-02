package io.github.eottabom.refactoring._02_duplicated_code.factory;

import java.util.List;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;

public class PostFactory {

	public static Post getPost(int postId) {
		return switch (postId) {
			case 15 -> new Post(15, List.of(
					new Comment("alice", "Thank you for the good writing.."),
					new Comment("bob", "I learned a lot."),
					new Comment("tom", "I'll see you again.")
			));
			case 30 -> new Post(30, List.of(
					new Comment("dave", "Thank you for your efforts."),
					new Comment("erin", "Thank you."),
					new Comment("logan", "That was a good review.")
			));
			default -> new Post(postId, List.of());
		};
	}

}
