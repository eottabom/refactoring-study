/**
 * 리팩토링 20. 세터 제거하기.
 * Remove Setting Method.
 *
 * 세터를 제공한다는 것은 해당 필드가 변경될 수 있다는 것을 의미한다.
 *
 * 객체 생성시 처음 설정된 값이 변경될 필요가 없다면,
 * 해당 값을 설정할 수 있는 셍성자를 만들고 세터를 제거해서 변경 가능성을 제거하는 것이 좋다.
 */
package io.github.eottabom.refactoring._06_mutable_data._20.remove_setting_method;