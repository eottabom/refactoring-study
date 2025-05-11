/**
 * 리팩토링 31. 타입 코드를 서브클래스로 바꾸기.
 * Replace Type Code with Subclasses
 *
 * 비슷한 것들이지만, 분류가 다르거나 다른 타입을 표현해야하는 경우,
 * ex) 주문 : 일반 주문, 빠른 주문
 * ex) 직원 : 엔지니어, 매니저, 세일즈
 *
 * 이걸 Primitive 타입을 쓰게 되면,
 * 각기 다른 로직을 써야 하는 경우가 되는데,
 * 이때 서브 클래스로 변경해서 리팩토링을 할 수 있다.
 *
 * 다형성을 활용할 수 있는 조건부 로직을 사용할 때,
 * 특정 타입에만 유효한 필드가 있는데, 이 때는 서브클래스를 만들고 필드 내리기를 활용한다.
 */
package io.github.eottabom.refactoring._11_primitive_obsession._31_replace_tyep_code_with_subclasses;
