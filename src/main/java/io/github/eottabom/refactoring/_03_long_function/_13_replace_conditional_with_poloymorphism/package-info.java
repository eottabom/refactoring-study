/**
 * 리팩토링 13. 조건문을 다형성으로 바꾸기.
 * Replace Conditional with Polymorphism
 *
 * 스위치는 true, false 가 아니고 각각의 타입에 따른 클래스를 만들어서 다형성으로 할 수도 있고,
 * if/else 문도 그렇게한다면,
 *
 * 거대한 클래스, 메서드를 나눌 수 가 있다.
 *
 * 모든 조건문을 다 다형성으로 바꾸라는 이야기는 아님!!
 * 오로지 복잡한 케이스에 각각의 타입이 있고 달라지는 부분이 있는 경우에만 다형성을 사용해서 바꾸는 것을 고려해야한다.
 */
package io.github.eottabom.refactoring._03_long_function._13_replace_conditional_with_poloymorphism;