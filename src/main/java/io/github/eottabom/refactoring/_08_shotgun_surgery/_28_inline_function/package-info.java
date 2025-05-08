/**
 * 리팩토링 28. 함수 인라인.
 * Inline Function
 *
 * Extract Function 의 반대 개념 = 함수 추출하기는 함수가 하는 역할을 쪼개서 함수의 이름으로 의도를 표현하는 방법.
 *
 * 뽑아져있는 함수를 없애는 기술이다.
 * 대부분은 Extract Function 이 더 적절할 것.. -> 그래야 의도가 더 명확해진다.
 *
 * 1) 간혹 함수 이름 자체가 하는 일을 잘 표현을 못하는 경우나, 본문을 봤을 때 오히려 더 의도파악이 쉬운 경우에 Inline Function 을 사용한다.
 * 2) Extract Function 을 했는데 잘못 분리한 경우에 다시 합쳐두고 다시 분리하기 위해서 사용할 수 있다.
 * 3) 단순한 메서드 호출을 감싸는 경우
 * -> 감쌌을 때 의미의 변화가 있을 때는 상관 없는데, 의미 없이 단순히 메서드를 감싸는 경우
 *
 * 상속 구조에서 오버라이딩하고 있는 메서드는 Inline 할 수 없다. (다형성을 깨뜨리는 것이므로)
 */
package io.github.eottabom.refactoring._08_shotgun_surgery._28_inline_function;
