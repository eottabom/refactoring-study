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

	private final Set<String> comments = new HashSet<>();

	public Set<String> getUserNames() {
		return this.userNames;
	}

	public Set<String> getComments() {
		return this.comments;
	}

	/*
		사실 게시글 reply 라는 표현보다는,
		게시글에 달린 댓글이라는 표현이 더 적합할 것 같다.
		그래서, replies -> comments 로 변경하는 것이 적합하다.
	 */
	/**
	 * 게시글 reply 에 작성되어 있는 댓글 작성자 목록과 댓글을 읽어옵니다.
	 */
	private void loadComments() {
		var article = ArticleFactory.getArticle(0);
		for (Comment comment : article.getComments()) {
			userNames.add(comment.userName());
			comments.add((comment.content()));
		}
	}

	public static void main(String[] args) {
		var dashBoard = new ArticleDashBoard();
		dashBoard.loadComments();
		/*
			lambda 식은 범위가 좁다.
			그 내용이 어떤게 들어 있는지 대부분 아는 경우가 많다.
			따라서 간추려서 쓰거나,
			(name) -> System.out.println(name) -> (n) -> System.out.println(n)
			좀 더 명시적으로 쓰거나,
			메서드 레퍼런스로 변경하면 메서드 이름을 쓰지 않게 된다.
			ex) System.out::println
		 */
		dashBoard.getUserNames().forEach(System.out::println);
		dashBoard.getComments().forEach(System.out::println);
	}
}
