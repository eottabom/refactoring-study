package io.github.eottabom.refactoring._10_data_clumps._00_before;

public class Author {

	private String name;

	private String tagCode;

	private String tagNumber;

	public Author(String name, String tagCode, String tagNumber) {
		this.name = name;
		this.tagCode = tagCode;
		this.tagNumber = tagNumber;
	}

	public String getTag() {
		return this.tagCode + "-" + this.tagNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
