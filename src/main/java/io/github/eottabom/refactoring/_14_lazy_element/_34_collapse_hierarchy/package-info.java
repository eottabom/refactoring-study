/**
 * 리팩토링 34. 계층 합치기
 * Collapse Hierarchy
 *
 * 상속 구조에 있는 클래스를 리픽토링 하는 중에 기능을 올리고 내리다보면
 * 하위 클래스와 상위 클래스 코드에 차이가 없는 경우가 발생하게 되는데, 이를 합칠 수 있다.
 *
 * 하위 클래스 상위 클래스 중에 어떤 것을 없애야 할까?
 * 둘 중에 이름이 적절한 것을 선택하지만, 어떤걸 선택해도 상관 없다.
 */
package io.github.eottabom.refactoring._14_lazy_element._34_collapse_hierarchy;
