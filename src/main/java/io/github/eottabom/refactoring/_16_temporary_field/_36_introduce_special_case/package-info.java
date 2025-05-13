/**
 * 리팩토링 36. 특이 케이스 추가하기.
 * Introduce Special Case
 *
 * 어떤 특정한 경우에만 값이 설정되거나 특정 경우에만 값이 변경이 되는 경우를 의미하는 것.
 * 이런 경우에 따라 바뀌는 로직이 여러번 반복해서 등장한다면,
 * 특이 케이스 자체를 별도의 클래스나 elements 로 추출하는 것을 의미하는것.
 *
 * Null Object Pattern 을 일종의 Introduce Special Case 라고 할 수 있다.
 * -> 무조건 Null 인 경우를 별도의 클래스로 빼는 것.
 *
 * Null Object Pattern 는 Introduce Special Case 의 일반화된 패턴이다.
 *
 * 코드에서 이 값이 이런 경우에 이런 로직을 처리하고,
 * 다른 코드에서도 반복되면 이런 리팩토링을 적용할 수 있다.
 */
package io.github.eottabom.refactoring._16_temporary_field._36_introduce_special_case;
