package io.github.eottabom.refactoring._01_smell_mysterious_name._04_using_record;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring._01_smell_mysterious_name.commons.ArticleFactory;

/**
 * ArticleDashBoard 는 0번 게시글의 댓글들을 조회해서,
 * 댓글 작성자 이름과 댓글 내용을 가져와서 출력하는 역할을 한다.
 */
public class ArticleDashBoard {

	/*
		commenters, comments 를 ArticleComment 라는 record 로 바꿀 수 있다.
	 */
	private final Set<ArticleComment> articleComments = new HashSet<>();

	public Set<ArticleComment> getArticleComments() {
		return this.articleComments;
	}

	/**
	 * 게시글 reply 에 작성되어 있는 댓글 작성자 목록과 댓글을 읽어옵니다.
	 */
	private void loadComments() {
		var article = ArticleFactory.getArticle(0);
		var comments = article.getComments();
		for (Comment comment : comments) {
			articleComments.add(new ArticleComment(comment.userName(), comment.content()));
		}
	}

	public static void main(String[] args) {
		var dashBoard = new ArticleDashBoard();
		dashBoard.loadComments();
		dashBoard.getArticleComments().forEach(System.out::println);
	}
}
