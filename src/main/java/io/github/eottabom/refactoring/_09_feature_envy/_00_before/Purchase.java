package io.github.eottabom.refactoring._09_feature_envy._00_before;

public class Purchase {

	private PaperBook paperBook;

	private EBook eBook;

	public double calculateTotalPrice() {
		double paperTotal = paperBook.getQuantity() * paperBook.getPricePerBook();
		double ebookTotal = eBook.getQuantity() * eBook.getPricePerBook();
		return paperTotal + ebookTotal;
	}

}
