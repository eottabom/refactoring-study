package io.github.eottabom.refactoring._09_feature_envy;

public class Purchase {

	private PaperBook paperBook;

	private EBook eBook;

	// @formatter:off
	/*
		이 부분이 Feature Envy 라고 생각이든다.
		왜냐면 quantity 와 pricePerBook 를 참조해서 여기서 계산을 하고 있다.
		사실 계산하는 부분은 각각의 PaperBook, EBook 클래스에서 해줘도 된다.
	 */
	public double calculateTotalPrice() {
		// STEP 1) 메서드 추출
//		var paperTotal = getPaperTotal();
//		var paperTotal = eBook.getQuantity() * eBook.getPricePerBook();
//		var ebookTotal = getEbookTotal();
//		var ebookTotal = eBook.getQuantity() * eBook.getPricePerBook();
//		return paperTotal + ebookTotal;

		// STEP 3)
		var paperTotal = paperBook.getPaperTotal();
		var ebookTotal = eBook.getEbookTotal();
		return paperTotal + ebookTotal;
	}

	// STEP 2) 이 메서드들을 해당 클래스들로 이동 시키면된다.
	// STEP 1) 메서드 추출
//	private double getPaperTotal() {
//		return paperBook.getQuantity() * paperBook.getPricePerBook();
//	}

	// STEP 2) 이 메서드들을 해당 클래스들로 이동 시키면된다.
	// STEP 1) 메서드 추출
//	private double getEbookTotal() {
//		return eBook.getQuantity() * eBook.getPricePerBook();
//	}
	// @formatter:on

}
