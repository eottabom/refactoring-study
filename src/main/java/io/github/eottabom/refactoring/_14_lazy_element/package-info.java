/**
 * 냄새 14. 성의 없는 요소.
 * Lazy Element
 *
 * Lazy 라고해서 게으른 으로 해석할 수 있는데,
 * 필드를 정의하거나 메서드를 만드는 프로그래밍적인 요소들을 Element 라고 부르는데,
 * 그렇게 필요 없는 요소들이 만들어지게 되고,
 * 리팩토링을 하게 되면 필요 없는 Element 들이 생기게 된다.
 * 이런 것들이 발생했을 때 Lazy Element 라고 하는데, 필요 없는 요소들이라고 보면 된다.
 *
 * 이런것들이 보이면 제거하면된다.
 * 관련 기술
 * 1) Inline Function (함수 인라인)
 * 2) Inline Class (클래스 인라인)
 * 3) 불필요한 상속 구조는 Collapse Hierarchy (계층 합치기) 를 사용할 수 있다.
 * - 메서드 올리기 내리기등을 했을 때 상위 클래스와 하위 클래스의 차이가 없는 경우에 사용할 수 있다.
 */
package io.github.eottabom.refactoring._14_lazy_element;
