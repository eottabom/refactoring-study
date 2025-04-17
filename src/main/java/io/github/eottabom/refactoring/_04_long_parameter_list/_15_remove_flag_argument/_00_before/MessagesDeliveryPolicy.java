package io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument._00_before;

import java.time.LocalDateTime;

import io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument.Message;

public class MessagesDeliveryPolicy {

	public LocalDateTime deliveryDate(Message message, boolean isHighPriority) {
		if (isHighPriority) {
			int deliveryTime = switch (message.getChannel()) {
				case "EMAIL", "PUSH" -> 1;
				case "SMS" -> 2;
				default -> 3;
			};
			return message.getRequestAt().plusDays(deliveryTime);
		}
		else {
			int deliveryTime = switch (message.getChannel()) {
				case "EMAIL" -> 2;
				case "SMS", "PUSH" -> 3;
				default -> 4;
			};
			return message.getRequestAt().plusDays(deliveryTime);
		}
	}

}
