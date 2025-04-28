package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform._00_before;

import java.time.Month;
import java.time.Year;

public class UploadClient {

	public double costPerMb(Year year, Month month) {
		return 5;
	}

	public double monthlyQuota(Year year) {
		return 50;
	}

}
