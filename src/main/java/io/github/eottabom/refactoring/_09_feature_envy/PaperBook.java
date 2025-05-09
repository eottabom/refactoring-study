package io.github.eottabom.refactoring._09_feature_envy;

public class PaperBook {

	private final int quantity;

	private final double pricePerBook;

	public PaperBook(int quantity, double pricePerBook) {
		this.quantity = quantity;
		this.pricePerBook = pricePerBook;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public double getPricePerBook() {
		return this.pricePerBook;
	}

	// @formatter:off
	// 메서드를 옮기면서 접근지시자 변경 (private -> public)
	public double getPaperTotal() {
		return this.quantity * this.pricePerBook;
//		return paperBook.getQuantity() * paperBook.getPricePerBook();
	}
	// @formatter:on
}
