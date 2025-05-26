package io.github.eottabom.refactoring._00_catalog.catalog_05;

public class GuardClauses {

	// 책에서는 50/50 인 경우 if/else 를 쓰는 것이 적합하다고 한다.
	// 하지만, 특수한 경우를 처리할 때는 저절하지 않다고 한다.
	public int getPoints() {
		int result;

		// 이런식으로 리팩토링 하라는 것이고,
		// return vipPoint() 로 바로 리턴해주는것이 보호 구문이라는 것이다.
		if (isVip()) {
			return vipPoint();
		}
		if (isPlat()) {
			return platPoint();
		}
		return normalPoint();

//		if (isVip()) {
//			result = vipPoint();
//		}
//		else if (isPlat()) {
//			result = platPoint();
//		}
//		else {
//			result = normalPoint();
//		}
//		return result;
	}

	private int normalPoint() {
		return 0;
	}

	private int vipPoint() {
		return 1;
	}

	private int platPoint() {
		return 2;
	}

	private boolean isVip() {
		return false;
	}

	private boolean isPlat() {
		return false;
	}

}
