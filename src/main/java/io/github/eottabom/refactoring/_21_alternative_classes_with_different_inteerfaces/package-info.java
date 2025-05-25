/**
 * 냄새 21. 서로 다른 인터페이스의 대안 클래스들.
 * Alternative Classes with Different Interfaces
 *
 * Alternative Classes 는 서로 교체할 수 있는 클래스들.
 * 비슷한 기능을 지원하는 클래스들.
 *
 * 비슷하지만 약간 다른일을 하는데 서로 호환되지 않는 인터페이스를 쓰는 경우를 의미한다.
 * -> 대안 클래스로 사용하려면 동일한 인터페이스를 구현하고 있어야 한다.
 *
 * Change Function Declaration (함수 선언 변경하기) 와 Move Function (함수 옮기기) 를 사용해서
 * 서로 동일한 인터페이스를 구현하게 끔 코드를 수정할 수 있다.
 *
 * 두 클래스에서 일부 코드가 중복되는 경우라면, Extract Superclass (슈퍼클래스 추출하기) 를 사용해서,
 * 중복 된 코드를 슈퍼 클래스로 옮기고, 두 클래스를 새로운 슈퍼클래스의 서브 클래스로 만들 수 있다.
 */
package io.github.eottabom.refactoring._21_alternative_classes_with_different_inteerfaces;
