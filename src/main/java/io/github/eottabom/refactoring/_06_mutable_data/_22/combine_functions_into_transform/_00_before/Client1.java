package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform._00_before;

public class Client1 extends UploadClient {

	private final double baseCost;

	public Client1(Upload upload) {
		this.baseCost = costPerMb(upload.year(), upload.month()) * upload.fileSize();
	}

	public double getBaseCost() {
		return this.baseCost;
	}

}
