/**
 * 리팩토링 15. 플래그 인수 제거하기.
 * Remove Flag Argument
 *
 * Flag 는 boolean 값이 아닌 Enum 이나 String 일 수도 있는데,
 * 보통 조건문으로 분기용으로 쓰는 매개변수를 보통 Flag 라고 한다.
 *
 * Flag 를 쓰는 것은 사실 좋은 방법은 아닌데,
 * 매개변수로 Flag 가 너무 많이 들어 있으면, 그 메서드는 사실 너무 많은 일을 한 곳에서 하는 것이라서 분리해야한다.
 * Flag 가 하나라고 하더라도, 기존 메서드에 다른 일을 하도록 하는 것의 시작이기도 하고,
 * 이 메서드가 하는 일의 의미를 호출하는 입장에서는 Flag 를 보지 않으면 이해하기 힘들다.
 *
 * 이러한 리팩토링을 할 때는,
 * 조건문 분해하기 Decompose Condition 을 활용 할 수 있다.
 * 이것도 사실 extract function 이라고 볼 수도 있다.
 *
 */
package io.github.eottabom.refactoring._04_long_parameter_list._15_remove_flag_argument;