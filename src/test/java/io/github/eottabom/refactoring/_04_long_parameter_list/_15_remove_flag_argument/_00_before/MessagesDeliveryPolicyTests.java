package io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument._00_before;

import java.time.LocalDateTime;

import io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument.Message;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessagesDeliveryPolicyTests {

	@Test
	void deliveryDate() {
		var requestAt = LocalDateTime.of(2021, 12, 15, 10, 30);
		var emailMessage = new Message(requestAt, "EMAIL");

		var policy = new MessagesDeliveryPolicy();
		// 운좋게도 인텔리제이에서 파라미터 이름을 보여주긴하는데..
		// 이런 도움이 없을때는 해당 메서드안에 들어가서 봐야한다.
		assertThat(requestAt.plusDays(1)).isEqualTo(policy.deliveryDate(emailMessage, true));
		assertThat(requestAt.plusDays(2)).isEqualTo(policy.deliveryDate(emailMessage, false));
	}

}
