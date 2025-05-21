package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate._00_before;

import java.util.List;

public class SuitePackage {

	private List<String> amenities;

	private double extraCharge;

	public SuitePackage(List<String> amenities, double extraCharge) {
		this.amenities = amenities;
		this.extraCharge = extraCharge;
	}

	public boolean hasAmenity(String amenity) {
		return this.amenities.contains(amenity);
	}

	public double getExtraCharge() {
		return this.extraCharge;
	}

}
