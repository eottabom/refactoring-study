package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform;

// @formatter:off
/*
	Client1, 2, 3 모두 기본 baseCost 를 계산하는 로직이 존재한다.
	각각의 클라이언트들이 동일한 메서드를 가질 수도 있고, 상위 클래스로 올려서 줄일 수도 있겠지만!
	여기서는 transform 을 이용해서 해보면..
*/
public class Client1 extends UploadClient {

	private final double baseCost;

	public Client1(Upload upload) {
		// 이 부분도 이제 변경이 가능하다.
//		this.baseCost = costPerMb(upload.year(), upload.month()) * upload.fileSize();
		this.baseCost = enrichUpload(upload).baseCost();
	}

	public double getBaseCost() {
		return this.baseCost;
	}
// @formatter:on
}
