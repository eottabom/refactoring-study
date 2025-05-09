package io.github.eottabom.refactoring._09_feature_envy._00_before;

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
}
