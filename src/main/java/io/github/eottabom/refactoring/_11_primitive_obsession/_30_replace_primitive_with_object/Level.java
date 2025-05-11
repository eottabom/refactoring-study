package io.github.eottabom.refactoring._11_primitive_obsession._30_replace_primitive_with_object;

import java.util.List;

public class Level {

	private String value;

	// STEP 3) Type Safety 보장
	// 이렇게 허용 가능한 값들을 선언하고,
	private List<String> legalValue = List.of("normal", "urgent", "emergency");

	public Level(String value) {
		// STEP 3) Type Safety 보장
		// 값을 확인해서 허용되지 않은 값을 예외처리하면됨.
		// 이러면 Type Safety 가 보장된다.
		if (this.legalValue.contains(value)) {
			this.value = value;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return this.value;
	}

	// STEP 4) 제공하기 위한 메서드 추가
	private int index() {
		return this.legalValue.indexOf(this.value);
	}

	// STEP 4) 제공하기 위한 메서드 추가
	// 추가로 제공하고 싶은 메서드이고, legalValue 의 list 의 인덱스를 이용해서 높은지 낮은지를 판별할 수 있다.
	public boolean urgentThan(Level other) {
		return this.index() >= other.index();
	}

}
