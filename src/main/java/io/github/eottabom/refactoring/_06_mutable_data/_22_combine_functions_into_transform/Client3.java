package io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform;

// @formatter:off
public class Client3 extends UploadClient {

	private final double baseCharge;

	public Client3(Upload upload) {
		// STEP 2) baseCharge 는 여기서 enrichUpload 의 baseCost 가 되어지고,
		this.baseCharge = enrichUpload(upload).baseCost();
//		this.baseCharge = calculateBaseCharge(upload);
	}

	// STEP 3) 이 메서드는 불필요해진다.
	private double calculateBaseCharge(Upload upload) {
		return costPerMb(upload.year(), upload.month()) * upload.fileSize();
	}

	public double getBaseCharge() {
		return this.baseCharge;
	}
// @formatter:on
}
