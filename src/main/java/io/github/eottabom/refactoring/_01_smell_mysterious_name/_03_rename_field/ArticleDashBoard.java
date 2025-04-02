package io.github.eottabom.refactoring._01_smell_mysterious_name._03_rename_field;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring._01_smell_mysterious_name.factory.ArticleFactory;

/**
 * ArticleDashBoard 는 0번 게시글의 댓글들을 조회해서,
 * 댓글 작성자 이름과 댓글 내용을 가져와서 출력하는 역할을 한다.
 */
public class ArticleDashBoard {

	/*
		userName 이라고 되어 있는데,
		사실 처음 작성할 때에는 userName 을 꺼내오니깐, userNames 라고 했는데,
		댓글을 단 사람들인, commenters 라고 해도 될 것 같다.
	 */
	private final Set<String> commenters = new HashSet<>();

	/*
		사실 게시글 reply 라는 표현보다는,
		게시글에 달린 댓글이라는 표현이 더 적합할 것 같다.
		그래서, replies -> comments 로 변경하는 것이 적합하다.
	 */
	private final Set<String> comments = new HashSet<>();

	public Set<String> getCommenters() {
		return this.commenters;
	}

	public Set<String> getComments() {
		return this.comments;
	}

	/**
	 * 게시글 reply 에 작성되어 있는 댓글 작성자 목록과 댓글을 읽어옵니다.
	 */
	private void loadComments() {
		var article = ArticleFactory.getArticle(0);
		var comments = article.getComments();
		for (Comment comment : comments) {
			commenters.add(comment.userName());
			this.comments.add((comment.content()));
		}
	}

	public static void main(String[] args) {
		var dashBoard = new ArticleDashBoard();
		dashBoard.loadComments();
		dashBoard.getCommenters().forEach(System.out::println);
		dashBoard.getComments().forEach(System.out::println);
	}
}
