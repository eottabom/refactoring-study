/**
 * 냄새 11. 기본형 집착.
 * Primitive Obsession
 *
 * 어플리케이션이나 프로그램을 만들때, 기본적으로 기본형 타입을 사용하게 되는데,
 * 어플리케이션을 계속해서 만들다보면, 기본형으로 표기하는것은 어려울 수 있다.
 * ex) 포맷팅, 돈 단위, 수량, 좌표 ..
 *
 * 관련 리팩토링
 * 1) Replace Primitive with Object (기본형을 객체로 바꾸기)
 * 2) Replace Type Code with Subclasses (타입 코드를 서브클래스로 바꾸기)
 * 3) Replace Conditional with Polymorphism (조건부 로직을 다형성으로 바꾸기)
 * 4) Extract Class (클래스 추출하기)
 * 5) Introduce Parameter Object (매개 변수 객체 만들기)
 */
package io.github.eottabom.refactoring._11_primitive_obsession;
