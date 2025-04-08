package io.github.eottabom.refactoring._01_smell_mysterious_name._00_before;

import java.util.HashSet;
import java.util.Set;

import io.github.eottabom.refactoring.Article;
import io.github.eottabom.refactoring.Comment;
import io.github.eottabom.refactoring._01_smell_mysterious_name.factory.ArticleFactory;

/**
 * ArticleDashBoard 는 0번 게시글의 댓글들을 조회해서, 댓글 작성자 이름과 댓글 내용을 가져와서 출력하는 역할을 한다.
 *
 * @author yukeun eottabom
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

	private void articleComments(Article article) {
		var comments = article.getComments();
		for (Comment comment : comments) {
			this.userNames.add(comment.userName());
			this.replies.add((comment.content()));
		}
	}

	public static void main(String[] args) {
		var article = ArticleFactory.getArticle(0);

		var dashBoard = new ArticleDashBoard();
		dashBoard.articleComments(article);
		dashBoard.getUserNames().forEach((name) -> System.out.println(name));
		dashBoard.getReplies().forEach((reply) -> System.out.println(reply));
	}

}
