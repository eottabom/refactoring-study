package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform._00_before;

public class Client2 extends UploadClient {

	private final double baseCost;

	private final double overageCharge;

	public Client2(Upload upload) {
		this.baseCost = costPerMb(upload.year(), upload.month()) * upload.fileSize();
		this.overageCharge = Math.max(0, this.baseCost - monthlyQuota(upload.year()));
	}

	public double getBaseCost() {
		return this.baseCost;
	}

	public double getOverageCharge() {
		return this.overageCharge;
	}

}
