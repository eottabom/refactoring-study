package io.github.eottabom.refactoring._10_data_clumps;

public class Author {

	private String name;

	// @formatter:off
	/*
		이 예제에서 말하는 데이터 뭉치는 tagCode, tagNumber 이다.
		이 tagCode, tagNumber 를 포함하는 객체를 하나 만들어준다.
	 */
//	private String tagCode;

//	private String tagNumber;

	private Tag tag;

	// remove
//	public Author(String name, String tagCode, String tagNumber) {
//		this.name = name;
//		this.tagCode = tagCode;
//		this.tagNumber = tagNumber;
//	}

	// add
	public Author(String name, Tag tag) {
		this.name = name;
		this.tag = tag;
	}

	public String getTag() {
//		return this.tagCode + "-" + this.tagNumber;
		return this.tag.toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	// 아래는 사용하는 곳이 많다면 아래와 같이 위임을 할 수 있다.
	// 하지만, Tag 에 대한 접근을 허용하면 된다.
	public Tag getTagInfo() {
		return this.tag;
	}

//	public String getTagCode() {
////		return this.tagCode;
//		return this.tag.getTagCode();
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
