package io.github.eottabom.refactoring._10_data_clumps._00_before;

public class Board {

	private String title;

	// @formatter:off
	/*
		이 예제에서 말하는 데이터 뭉치는 categoryCode, postNumber 이다.
	 */
	// @formatter:on
	private String tagCode;

	private String tagNumber;

	public Board(String title, String tagCode, String tagNumber) {
		this.title = title;
		this.tagCode = tagCode;
		this.tagNumber = tagNumber;
	}

	public String getTag() {
		return this.tagCode + "-" + this.tagNumber;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTagCode() {
		return this.tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getTagNumber() {
		return this.tagNumber;
	}

	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}

}
