package io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument;

import java.time.LocalDateTime;

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

		// STEP2) 변경된 메서드로 변경한다. Flag 성 파라미터도 줄어들게 된다.
		assertThat(requestAt.plusDays(1)).isEqualTo(policy.highPriorityDate(emailMessage));
		assertThat(requestAt.plusDays(2)).isEqualTo(policy.regularPriorityDate(emailMessage));
	}

}
