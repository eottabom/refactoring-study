/**
 * 냄새 16. 임시 필드.
 * Temporary Field
 *
 * 어떤 필드의 값이 있는데, 그 값이 기본적으로 임시적인 값을 가지고 있는 경우
 * 쉽게 찾아볼 수 있는 임시값으로는 기본값, null 이런거나
 * empty 이런 값들을 냄새라고 표현한다.
 *
 * 이런 필드들을 가진 Object 가 가지고 있으면, 일반적으로 이해하기 힘들고,
 * 임시적인 값일 때 동작을 파악해야한다. (조건문이 있을것이고..)
 *
 * 이러한 코드들이 반복해서 나온다면 이것을 냄새라고 한다.
 *
 * 관련 리팩토링
 * 1) Extract Class (클래스 추출하기)
 * 2) Move Function (함수 옮기기)
 * 3) Introduce Special Case (특이 케이스 추출하기)
 * - 어떻게 보면 클래스 추출하기, 함수 옮기기의 특수한 형태의 리팩토링이라고 볼 수 있다.
 */
package io.github.eottabom.refactoring._16_temporary_field;
