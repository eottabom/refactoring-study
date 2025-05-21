package io.github.eottabom.refactoring._18_middle_man._40_replace_subclass_with_delegate._00_before;

import java.util.List;

public class Room {

	private List<String> amenities;

	private double baseRate;

	public Room(List<String> amenities, double baseRate) {
		this.amenities = amenities;
		this.baseRate = baseRate;
	}

	public boolean hasAmenity(String amenity) {
		return this.amenities.contains(amenity);
	}

	public double getBaseRate() {
		return this.baseRate;
	}

}
