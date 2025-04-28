/**
 * 리팩토링 21. 파생 변수를 질의 함수로 바꾸기.
 * Replace Derived Variable with Query.
 *
 * 어딘가에서 파생된, 계산된 변수이다.
 * 그 변수를 사용하던 변수를 함수로 바꾸는 것이다.
 *
 * 가급적이면 변경 될 수 있는 변수를 줄이는 방법중에 하나이다.
 * 계산하는 변수를 제거하고, 그대로 함수로 표현하는 것이다.
 *
 * 파생 값이 불변인 경우는 파생변수를 그대로 유지해도 된다.
 */
package io.github.eottabom.refactoring._06_mutable_data._21_replace_derived_variable_with_query;