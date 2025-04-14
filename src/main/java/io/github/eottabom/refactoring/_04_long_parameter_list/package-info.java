/**
 * 냄새4. 긴 매개변수 목록.
 * Long Parameter List
 *
 * 이 냄새는 long function 에서 이미 다룬 이야기이다.
 * replace parameter with query,
 * preserve whole object.
 * introduce parameter object.
 * remove flag argument.
 * combine function into object.
 * 으로 리팩토링 가능하다.
 *
 * 매개변수가 많아진다는 이야기는 그 함수가 여러가지 일을 한다는 것인데,
 * 함수를 쪼개면서, 다른 함수에서 매개변수를 추출할 수 있다면, 매개변수를 줄일 수 있다.
 */
package io.github.eottabom.refactoring._04_long_parameter_list;
