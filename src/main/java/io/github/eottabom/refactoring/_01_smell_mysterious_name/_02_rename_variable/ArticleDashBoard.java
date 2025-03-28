package io.github.eottabom.refactoring._01_smell_mysterious_name._02_rename_variable;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring._01_smell_mysterious_name.commons.ArticleFactory;

/**
 * ArticleDashBoard 는 0번 게시글의 댓글들을 조회해서,
 * 댓글 작성자 이름과 댓글 내용을 가져와서 출력하는 역할을 한다.
 */
public class ArticleDashBoard {

	private final Set<String> userNames = new HashSet<>();

	private final Set<String> replies = new HashSet<>();

	public Set<String> getUserNames() {
		return this.userNames;
	}

	public Set<String> getReplies() {
		return this.replies;
	}

	/*
		'articleComments' 라는 메서드 이름에서 'comments' 라는 것이
		article 에 대한 comment 를 한다는 것인지,
		article 에 대한 comment 를 읽어 온다는 것인지 의미적으로 모호하다.
		이 경우에는 책에 나온대로 메서드가 하는 일을 주석으로 달아보면,
		// 게시글 리뷰에 작성되어 있는 댓글 목록과 댓글을 읽어온다.
		라고 표현할 수 있을 것 같다.
		따라서, 'articleComments' 보다는 'load', 'get' 이런 것들이 의미적으로 맞다.

		두 번째로 매개 변수를 생각해보면,
		이 클래스의 역할은 0번 게시글의 댓글을 가져오는 것이라서,
		굳이 매개 변수로 article 을 받을 필요가 없을 것이다.
		따라서, 매개 변수를 아예 주지 않고, 이 메서드 자체에서 그 게시글로 부터 댓글을 읽어 올 수 있게 할 수 있다.
	 */

	/**
	 * 게시글 리뷰 에 작성되어 있는 댓글 작성자 목록과 댓글을 읽어옵니다.
	 */
	private void loadComments() {
		var article = ArticleFactory.getArticle(0);
		var comments = article.getComments();
		for (Comment comment : comments) {
			userNames.add(comment.userName());
			replies.add((comment.content()));
		}
	}

	public static void main(String[] args) {
		var dashBoard = new ArticleDashBoard();
		dashBoard.loadComments();
		dashBoard.getUserNames().forEach(System.out::println);
		dashBoard.getReplies().forEach(System.out::println);
	}
}
