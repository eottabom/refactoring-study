package io.github.eottabom.refactoring._01_smell_mysterious_name.factory;

import java.util.HashMap;
import java.util.Map;

import io.github.eottabom.refactoring.Article;
import io.github.eottabom.refactoring.Comment;

public final class ArticleFactory {

	private ArticleFactory() {
	}

	private static final Map<Integer, Article> ARTICLES = new HashMap<>();

	static {
		Article article = new Article("refactoring study");
		article.addComment(new Comment("alice", "Great article!"));
		article.addComment(new Comment("bob", "Very informative!"));
		article.addComment(new Comment("tom", "Thank you!"));

		ARTICLES.put(0, article);
	}

	public static Article getArticle(int key) {
		return ARTICLES.get(key);
	}

}
