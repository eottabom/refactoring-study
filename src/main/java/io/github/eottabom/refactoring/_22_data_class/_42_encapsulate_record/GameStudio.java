package io.github.eottabom.refactoring._22_data_class._42_encapsulate_record;

public class GameStudio {

	// 이런 클래스의 필드들이 있으면 접근이 가능하다.
	// public 한 메서드를 이용해서 필드들을 감추는 것이다.
	public String studioName;

	public String headquartersLocation;

	// 불변이 아니라면, 필드를 private 으로 바꾸고, getter, setter 를 이용해서 처리할 수 있다.
//	private String studioName;
//
//	private String headquartersLocation;
//
//	public String getStudioName() {
//		return this.studioName;
//	}
//
//	public void setStudioName(String studioName) {
//		this.studioName = studioName;
//	}
//
//	public String getHeadquartersLocation() {
//		return this.headquartersLocation;
//	}
//
//	public void setHeadquartersLocation(String headquartersLocation) {
//		this.headquartersLocation = headquartersLocation;
//	}

	// 불변이라면 이 클래스를 record 로 변경하면 된다.
}
