package io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

public class UploadClient {

	public double costPerMb(Year year, Month month) {
		return 5;
	}

	public double monthlyQuota(Year year) {
		return 10;
	}

	// STEP 1) 새로운 메서드를 만들고, 불변한 값을 return 해준다.
	protected EnrichUpload enrichUpload(Upload upload) {
//		return new EnrichUpload(upload);
		return new EnrichUpload(upload, calculateBaseCharge(upload), overageCharge(upload));
	}

	// STEP 4) calculateBaseCharge 는 이 클래스로 옮겨올 수 있다.
	private double calculateBaseCharge(Upload upload) {
		return costPerMb(upload.year(), upload.month()) * upload.fileSize();
	}

	public double overageCharge(Upload upload) {
		return Math.max(0, calculateBaseCharge(upload) + monthlyQuota(upload.year()));
	}

}
