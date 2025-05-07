package io.github.eottabom.refactoring._08_shotgun_surgery._27_move_field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

	private String productName;

	// STEP 4) 이제 여기서 rate 를 가질 필요가 없어진다.
//	private double rate;

	private Delivery delivery;

	public Order(String productName, double rate) {
		this.productName = productName;
		// @formatter:off
		/*
			여기서 rate 를 변경한다면, delivery 와 더 관련 있는 데이터로 변경사항이 발생한다면...!
			rate 를 delivery 로 옮기는 것이 타당할 수 있다.
		 */
		// STEP 4)
//		this.rate = rate;
		// STEP 3) rate 필드를 Delivery 로 전달해준다.
		this.delivery = new Delivery(today(), rate);
//		this.rate = rate;
//		this.delivery = new Delivery(today());
		// @formatter:on
	}

	// 추후에는 getRate, setRate 를 제거해줄 수도 있다.
	// @formatter:off
	public double getRate() {
		// STEP 4) rate 를 delivery 를 통해서 가져오도록 수정한다.
//		return this.rate;
		return this.delivery.getRate();
	}

	// STEP 1) add setRate
	public void setRate(double rate) {
		// STEP 4) rate 를 delivery 를 통해서 가져오도록 수정한다.
//		this.rate = rate;
		this.delivery.setRate(rate);
	}

	// + 사실 expediteShipping, calculateTotalCost 는 Delivery 로 옮기는 것이 더 적절할 수도 있다.
	// 신속 배달
	public void expediteShipping() {
		// STEP 2) 여기서 값을 추상화 시켜준다음에, 필드를 옮기는 것.
		this.setRate(this.getRate() + 0.5);
//		this.rate += 0.05;
	}


	public double calculateTotalCost(double basePrice) {
		BigDecimal price = BigDecimal.valueOf(basePrice);
		// STEP 1) this.rate 를 직접 필드로 받게 되어 있는데 setter 를 만들어준다.
//		return price.add(price.multiply(BigDecimal.valueOf(this.rate))).doubleValue();
		return price.add(price.multiply(BigDecimal.valueOf(this.getRate()))).doubleValue();
	}
	// @formatter:on

	private LocalDateTime today() {
		return LocalDateTime.now();
	}

}
