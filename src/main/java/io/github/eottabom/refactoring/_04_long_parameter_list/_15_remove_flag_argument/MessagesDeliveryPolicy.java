package io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDateTime;

public class MessagesDeliveryPolicy {

	// STEP3) 그러고 나면 이 메서드는 지워도 되게 된다.
	public LocalDateTime deliveryDate(Message message, boolean isHighPriority) {
		
		// STEP1) decompose conditional 로 각각의 조건에 해당하는 액션들을 메서드로 분리 (extract method)
		if (isHighPriority) {
			return highPriorityDate(message);
		}
		else {
			return regularPriorityDate(message);
		}
	}

	public LocalDateTime regularPriorityDate(Message message) {
		int deliveryTime = switch (message.getChannel()) {
			case "EMAIL" -> 2;
			case "SMS", "PUSH" -> 3;
			default -> 4;
		};
		return message.getRequestAt().plusDays(deliveryTime);
	}

	public LocalDateTime highPriorityDate(Message message) {
		int deliveryTime = switch (message.getChannel()) {
			case "EMAIL", "PUSH" -> 1;
			case "SMS" -> 2;
			default -> 3;
		};
		return message.getRequestAt().plusDays(deliveryTime);
	}

}
