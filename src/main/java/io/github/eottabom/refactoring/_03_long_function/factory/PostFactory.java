package io.github.eottabom.refactoring._03_long_function.factory;

import java.util.List;
import java.util.Map;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring.Post;

public class PostFactory {

	private static final Map<Integer, Post> posts = Map.of(
			1, new Post(1, List.of(
					new Comment("alice", "좋은 강의 감사합니다!"),
					new Comment("bob", "열심히 했어요!")
			)),
			2, new Post(2, List.of(
					new Comment("alice", "2주차 완료"),
					new Comment("charlie", "재밌었어요")
			)),
			3, new Post(3, List.of(
					new Comment("bob", "3주차 끝!"),
					new Comment("charlie", "3주차도 성공")
			))
			// ... 필요한 만큼 더 추가
	);
;
	public static Post getPost(int index) {
		return posts.getOrDefault(index, new Post(index, List.of()));
	}
}
