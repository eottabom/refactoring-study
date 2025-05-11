package io.github.eottabom.refactoring._10_data_clumps;

public class Board {

	private String title;

	// @formatter:off
	/*
		이 예제에서 말하는 데이터 뭉치는 tagCode, tagNumber 이다.
	 */
	private Tag tag;
//	private String tagCode;

//	private String tagNumber;

//	public Board(String title, String tagCode, String tagNumber) {
//		this.title = title;
//		this.tagCode = tagCode;
//		this.tagNumber = tagNumber;
//	}

	public Board(String title, Tag tag) {
		this.title = title;
		this.tag = tag;
	}

	public String getTag() {
		return this.tag.toString();
//		return this.tagCode + "-" + this.tagNumber;
	}

	public Tag getTagInfo() {
		return tag;
	}
//
//	public String getTitle() {
//		return this.title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getTagCode() {
//		return this.tagCode;
//	}
//
//	public void setTagCode(String tagCode) {
//		this.tagCode = tagCode;
//	}
//
//	public String getTagNumber() {
//		return this.tagNumber;
//	}
//
//	public void setTagNumber(String tagNumber) {
//		this.tagNumber = tagNumber;
//	}
	// @formatter:on

}
