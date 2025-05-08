/**
 * 리팩토링 29. 클래스 인라인.
 * Inline Class
 *
 * Extract Class 의 반대되는 개념
 * 클래스 전체의 필드와 메서드를 다른 클래스로 옮기는 것
 *
 * Inline Class 리팩토링을 하게 되는 이유?
 * 리팩토링을 하게 되면 클래스가 담당해야하는 역할, 일들이 옮겨다니게 된다.
 * - ex) move field, move method
 * - 그렇게 되면 어떤 클래스가 단순하게 위임이 되는 클래스가 되는 경우가 있다.
 * - 이때, 응집도를 높이기 위해서 사용된다.
 *
 * 리팩토링의 과정으로 사용되는 경우도 있다.
 * 두 개의 클래스를 여러 클래스로 나누는 리팩토링을 하는 경우,
 * 우선, Inline Class 를 통해 코드를 한 곳으로 모으고, 그 이후에 Extract Class 를 사용해서 새롭게 리팩토링을 할 수 있다.
 */
package io.github.eottabom.refactoring._08_shotgun_surgery._29_inline_class;
