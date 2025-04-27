/**
 * 리팩토링 19. 질의 함수와 변경 함수 분리하기.
 * Separate Query from Modifier
 *
 * Query = 보통 함수를 의미하고,
 * Modifier = 변경 내역을 일으킬 수 있는 함수를 의미한다.
 *
 * 둘을 구분하라는 것으로 이해하면 쉽다.
 * 조회하는 함수들과 값을 변경하는 함수들을 구분하자는 뜻임.
 *
 * 값을 리턴해주는 함수는 사이드 이팩트가 없어야 한다라는 규칙이다.
 * observable side effect 없이 값을 조회할 수 잇는 메서드가 테스트하기도 쉽고, 메서드를 이동하기도 편하다.
 *
 * 캐시 같은건 중요한 객체 상태 변화는 아니다.
 * 캐시 데이터는 변경하더라도 분리할 필요는 없다.
 */
package io.github.eottabom.refactoring._06_mutable_data._19_separate_query_from_modifier;