package io.github.eottabom.refactoring._10_data_clumps;

public class Tag {

	private String tagCode;

	private String tagNumber;

	public Tag(String tagCode, String tagNumber) {
		this.tagCode = tagCode;
		this.tagNumber = tagNumber;
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

	// add
	@Override
	public String toString() {
		return this.tagCode + " " + this.tagNumber;
	}
}
