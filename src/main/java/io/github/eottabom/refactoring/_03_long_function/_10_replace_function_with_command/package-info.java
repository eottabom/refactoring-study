/**
 * 리팩토링 10. 함수를 명령으로 바꾸기.
 * Replace Function with Command
 *
 * 디자인 패턴에서 Command 패턴처럼
 * Operation 하나를 인스턴스로 만드는 패턴이고, undo 라는 기능을 구현할 수 있는 패턴인데,
 *
 * 이것과 비슷한 맥락의 Command 이다.
 *
 * 함수 하나를 독립적인 Command 로 분리할 수 있다.
 * 복잡한 메서드를 잘게 분해하면서 코드를 간추릴 수가 있다.
 *
 * 단점
 * 새로운 클래스를 만들거나 구조가 변경되기 때문에 복잡도가 증가 할 수 있다.
 *
 * Command 로 빼내면서 취할 수 있는 장점도 있고,
 * 함수 분리를 고려해보고, 그래도 분리가 필요하다고 생각되면 Command 로 적용할 수 있다.
 */
package io.github.eottabom.refactoring._03_long_function._10_replace_function_with_command;