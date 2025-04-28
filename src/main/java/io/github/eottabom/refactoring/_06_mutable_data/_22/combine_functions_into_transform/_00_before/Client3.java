package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform._00_before;

public class Client3 extends UploadClient {

	private final double baseCharge;

	public Client3(Upload upload) {
		this.baseCharge = calculateUploadCost(upload);
	}

	private double calculateUploadCost(Upload upload) {
		return costPerMb(upload.year(), upload.month()) * upload.fileSize();
	}

	public double getBaseCharge() {
		return this.baseCharge;
	}

}
