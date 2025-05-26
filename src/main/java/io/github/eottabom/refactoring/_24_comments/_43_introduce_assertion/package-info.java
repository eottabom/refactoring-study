/**
 * 리팩토링 43. 어선셔 추가하기.
 * introduce Assertion
 *
 * 코드로 표현하지는 않지만 기본적으로 가정하고 하는 조건들이 있다.
 * 이런 조건들을 Assertion 으로 표현해주면 디버깅할 때 유용할 수도 있다.
 *
 * assertion 은 if 나 switch 문과 달리 항상 true 이길 기대하는 조건을 표현할 때 사용한다.
 * assertion 에서 실패한다면 프로그래머의 실수 인 것이다.
 * assertion 없이도 프로그램이 동작해야한다.
 *
 * 특정 부분에서는 특정한 상태를 가정하고 있다는 것을 명시적으로 나타내면서 의사소통적인 가치를 가지고 있다.
 */
package io.github.eottabom.refactoring._24_comments._43_introduce_assertion;
