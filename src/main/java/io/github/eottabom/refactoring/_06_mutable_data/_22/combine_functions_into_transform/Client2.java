package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform;

// @formatter:off
public class Client2 extends UploadClient {

	private final double baseCost;

	private double overageCharge;

	public Client2(Upload upload) {
		// 이 부분도 변경 가능하다.
//		this.base = costPerMb(upload.year(), upload.month()) * upload.fileSize();
		this.baseCost = enrichUpload(upload).baseCost();

		// 이 부분도 여러곳에서 사용된다면, EnrichUpload 로 이동 시킬 수 있다.
//		this.overageCharge = Math.max(0, this.base - monthlyQuota(upload.year()));

		EnrichUpload enrichUpload = enrichUpload(upload);
		this.overageCharge = enrichUpload.overCost();
	}


	public double getBaseCost() {
		return this.baseCost;
	}

	public double getOverageCharge() {
		return this.overageCharge;
	}
// @formatter:on

}
